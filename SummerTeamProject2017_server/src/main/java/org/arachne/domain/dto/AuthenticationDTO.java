package org.arachne.domain.dto;



import groovy.transform.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode
public class AuthenticationDTO {

	private String username;
	private String password;

	
	
}
