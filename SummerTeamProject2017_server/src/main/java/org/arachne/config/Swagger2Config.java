package org.arachne.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import com.google.common.base.Predicate;

import static springfox.documentation.builders.PathSelectors.*;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class Swagger2Config {

	@Bean
	public Docket swaggerSpringMvcPlugin() {

		return new Docket(DocumentationType.SWAGGER_2)

				.select()
				   			
				.apis(RequestHandlerSelectors.basePackage("org.arachne.presentation.restapi"))
				.paths(PathSelectors.ant("/api/**"))
				.build();
				
	}

	
	
}