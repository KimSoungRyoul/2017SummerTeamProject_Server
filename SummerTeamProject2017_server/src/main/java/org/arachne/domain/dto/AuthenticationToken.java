package org.arachne.domain.dto;

import java.util.Collection;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AuthenticationToken {

	private String username;
	private Collection<?> authorities;
	private String token;

	public AuthenticationToken(String username, Collection<?> collection, String token) {
		this.username = username;
		this.authorities = collection;
		this.token = token;
	}

}