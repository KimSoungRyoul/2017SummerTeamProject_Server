package org.arachne.presentation.restapi;

import java.util.HashMap;
import java.util.Map;

import org.arachne.application.MemberAccountLoginService;
import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.dto.HttpStateDTO;
import org.arachne.domain.dto.HttpStateDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping(value="/api/members")
@Log4j
public class MemberAPI {

	@Autowired
	private MemberAccountLoginService memberService;
	
	@GetMapping(value="/{userid}")
	public ResponseEntity<Map<String, Object>> GETMemberAccount(@PathVariable("userid")String userid){
	
		ResponseEntity<Map<String, Object>> response=null;
		Map<String, Object> result=new HashMap<>();
		
		userid=userid.replace("*", ".");
		
		log.info("userid"+": ___________" + userid);
		
		
		
		try{
			MemberAccount member=(MemberAccount) memberService.readUser(userid);
			
			
			
			result.put("memberInfo", member);
			
			
			
			
			result.put("state", HttpStateDTOFactory.get200());
			
			response=new ResponseEntity<>(result,HttpStatus.OK);
			
			log.info("정상처리?");
		}catch(UsernameNotFoundException e){
			
			
			result.put("state", HttpStateDTOFactory.get204());
			
			response=new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
			
			log.info("error?????");
			
		}
		
		return response;
	}
	
	
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> signUpMember(@RequestBody MemberAccount account){
		
		ResponseEntity<Map<String, Object>> response=null;
		Map<String, Object> result=new HashMap<>();
		
		try {
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
		
		
		
	}
	
	
}
