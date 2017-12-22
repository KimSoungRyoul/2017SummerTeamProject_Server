package org.arachne.domain.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class HttpStateDTO implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1692088508372971923L;
	
	@Getter
	private HttpStatus stateCode;
	@Getter
	private String description;

	
	
	
	
}
