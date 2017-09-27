package org.arachne.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;




@Component
@Qualifier("profile")
//@Log4j
public class ProfilephotoFileUtil implements MultiPartFileUtil{


	
	
	@Override
	public String upload(MultipartFile file,String userEmail,String defualtUploadPath) {
		// TODO Auto-generated method stub
		
		UUID uid=UUID.randomUUID();
		String uploadedFileName = null;
		try {
			String originalName=new String(file.getOriginalFilename());
			//log.info(originalName+"------------------------------");
			
			String savedName=uid.toString()+"__"+originalName;
			
			//log.info(savedName+"-------------저장 파일 명-----------------");
			
			
			
			String savedPath=calcPath(defualtUploadPath,userEmail);
			
		//	log.info(savedPath+"-------저장 경로-----------------------");
			
			
			File target=new File(defualtUploadPath+savedPath,savedName);
			
			FileCopyUtils.copy(file.getBytes(), target);

			String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);

			

			if (MediaTypeUtils.getMediaType(formatName) != null) {
				uploadedFileName = makeThumbnail(defualtUploadPath, savedPath, savedName);
				uploadedFileName = makeIcon(defualtUploadPath, savedPath, savedName);
			} else {
				uploadedFileName = makeIcon(defualtUploadPath, savedPath, savedName);
			}

			
			
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uploadedFileName;
		
		
	}


	@Override
	public void delete(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	
	private static String calcPath(String defaultUploadPath,String userAccount) {

	
		
		if(userAccount.contains("."))
			userAccount=userAccount.replace(".", "_");
		
		//log.info(userAccount+ "-----유저 계정 파일경로명 변경---");
		
		
		
		
		
		String filePath1=File.separator+userAccount;
		
		String filePath2=File.separator+userAccount+File.separator+"profilePhoto";
		
		
		
		
		//log.info(filePath2+"------생성되는 폴더 ");
		
		
		
		
		makeDir(defaultUploadPath, filePath1,filePath2);

		

		return filePath2;

	}
	
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;

		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 200);

		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;

		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	
	
	private static void makeDir(String defaultUploadPath,String... paths) {

		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		for (String path : paths) {

			File dirPath = new File(defaultUploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

}
