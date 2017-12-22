package org.arachne.domain.dto;




import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AuthenticationDTO {

	private String username;
	private String password;

	
	
}
