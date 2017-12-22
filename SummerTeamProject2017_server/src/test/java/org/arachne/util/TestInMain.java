package org.arachne.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.account.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.gson.Gson;

public class TestInMain {

	public static void main(String[] args) {
		
		
		
		StringBuilder fileNameBuilder=new StringBuilder();
		
		String fileName=fileNameBuilder.append("D:\\personalProject\\SummerTeamProject2017")
									.append(File.separator).append("test@naver_com")
									.append(File.separator).append("profilePhoto")
									.toString();
		
		
		System.out.println(fileName);
		
		
		
		
	}
}
