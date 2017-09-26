package org.arachne.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;




@Component
@Qualifier("profile")
@Log4j
public class ProfilephotoFileUtil implements MultiPartFileUtil{


	
	private static String uploadPath= "D:\\personalProject";
	
	@Override
	public String upload(MultipartFile file,String userEmail) {
		// TODO Auto-generated method stub
		
		UUID uid=UUID.randomUUID();
		String uploadedFileName = null;
		try {
			String originalName=new String(file.getOriginalFilename());
			log.info(originalName+"------------------------------");
			
			String savedName=uid.toString()+"__"+originalName;
			
			log.info(savedName+"------------------------------");
			
			
			
			String savedPath=calcPath(savedName,userEmail);
			
			log.info(savedPath+"------------------------------");
			
			
			File target=new File(uploadPath+savedPath,savedName);
			
			FileCopyUtils.copy(file.getBytes(), target);

			String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);

			

			if (MediaTypeUtils.getMediaType(formatName) != null) {
				uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
				uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			} else {
				uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
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
	
	
	private static String calcPath(String savedName,String userAccount) {

	
		
		if(userAccount.contains("."))
			userAccount=userAccount.replaceAll(".", "_");
		
		
		
		
		
		String filePath=File.separator+savedName;
		
		filePath=File.separator+userAccount+File.separator+"profilePhoto"+filePath;
		
		
		
		
		makeDir(uploadPath, filePath);

		

		return filePath;

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
	
	
	
	private static void makeDir(String uploadPath, String... paths) {

		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		for (String path : paths) {

			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

}
