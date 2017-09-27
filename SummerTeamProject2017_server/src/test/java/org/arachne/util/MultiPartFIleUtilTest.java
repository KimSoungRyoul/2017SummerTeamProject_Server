package org.arachne.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class MultiPartFIleUtilTest {

	@Autowired
	@Qualifier("profile")
	private MultiPartFileUtil profileUploader;
	
	
	@Autowired
	private String defaultUploadPath;
	
	@Test
	public void test_upload_ProfilePhotoFile(){
		
		
		String uploadFilePath=null;
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
	
}
