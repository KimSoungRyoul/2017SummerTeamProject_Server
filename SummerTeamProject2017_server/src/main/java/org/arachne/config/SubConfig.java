package org.arachne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


/*
 * 2017.09.27 현재 SubConfig 는 대용량 파일 처리를 위한 설정 값들을 가지고 있음 
 * 향후 더이상 추가되는 설정이 없을 경우 클래스 명을 MultipartFileConfig 로 변경할것
 */





@Configuration
public class SubConfig {

	
	@Bean("uploadPath")
	@Profile("dev")
	public String uploadPath(){
		return "D:\\personalProject\\SummerTeamProject2017";
	}
	
	@Bean("uploadPath")
	@Profile("product")
	public String uploadPath2(){
		return "D:\\personalProject";
	}
	
	
	@Bean
	public MultipartResolver multpartResolver(){
		
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(100000000);
		multipartResolver.setMaxInMemorySize(100000000);

		return multipartResolver;
	}
	
}
