package org.arachne.util;

import java.io.File;

import org.arachne.domain.testvo.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.gson.Gson;

public class TestInMain {

	
	public static void main(String[] args) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		System.out.println( passwordEncoder.encode("1234"));
		
		
	}
}
