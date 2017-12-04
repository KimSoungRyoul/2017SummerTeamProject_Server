package org.arachne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
public class SummerTeamProject2017ServerApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SummerTeamProject2017ServerApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()throws Exception{
		
		return new BCryptPasswordEncoder();
	}
	
	
}
