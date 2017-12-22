package org.arachne.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Log4j
public class MultiPartFIleUtilTest {

	@Autowired
	@Qualifier("profilePhoto")
	private MultiPartFileUtil profileUploader;
	
	
	@Autowired
	private String defaultUploadPath;
	
	private static String uploadFilePath;
	
	@Test
	public void test01_upload_ProfilePhotoFile(){
		
		
		
		try {
			File file=new File("D:\\personalProject\\KimOuBinImage.jpg");
			
			MultipartFile multiFile=new MockMultipartFile(defaultUploadPath+File.separator+"KimOuBinImage.jpg",
					"KimOuBinImage.jpg", "JPG", new FileInputStream(file));
			
			
			uploadFilePath=profileUploader.upload(multiFile,"test@naver.com",defaultUploadPath);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("테스트 이미지 경로 잘못됨 이미지를 찾을수 없음");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			fail("입출력 과정에서 무언가가 잘못됨 IO 익셉션");
		}
		
		assertNotNull(new File(uploadFilePath));
		
		
	}
	
	
	@Test
	public void test02_delete_ProfilePhtoFile() {
		
		
		
		profileUploader.delete(uploadFilePath);
		
		log.info(defaultUploadPath+uploadFilePath);
		
		File deletedFile=new File(defaultUploadPath+uploadFilePath);
		
		assertFalse( deletedFile.exists());
		
	}
	
	
	
	
	
	
	
	
}
