package org.arachne.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode
public class UserInfo {

	
	private String email;
	private String password;
	private String name;
	private String phoneNum;
	
	private Date birthDate;
	private Date regDate;
	//private NationalObligation obligation; //병역 여부
	
	
	
	//private FileInfo userProfilePhoto;
	
	public UserInfo(){
		
		
	}
	
	
	
}
