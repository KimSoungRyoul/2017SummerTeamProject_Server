package org.arachne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SubConfig {

	
	@Bean("uploadPath")
	@Profile("dev")
	public String uploadPath(){
		return "D:\\personalProject";
	}
	
	@Bean("uploadPath")
	@Profile("product")
	public String uploadPath2(){
		return "D:\\personalProject";
	}
	
}
