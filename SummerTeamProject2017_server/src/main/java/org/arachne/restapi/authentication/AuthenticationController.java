package org.arachne.restapi.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.arachne.application.MemberAccountLoginService;
import org.arachne.domain.account.AuthorityType;
import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.account.Role;
import org.arachne.domain.dto.AuthenticationDTO;
import org.arachne.domain.dto.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping(value= "/user", method=RequestMethod.GET)
@Log4j
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MemberAccountLoginService mAccountLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthenticationToken login(@RequestBody AuthenticationDTO authenticationDTO, HttpSession session) {
	
		
		String username = authenticationDTO.getUsername();
		String password = authenticationDTO.getPassword();
		
		log.info("username: "+username + "---- userpassword: "+password);
		
		List<Role> roles=new ArrayList<>();
		
		Role role=new Role();
		role.setAuthorityType(AuthorityType.NORMAL_USER);
		
		
		roles.add(role);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, roles);
	
		//log.info(token.toString());
		
		
		Authentication authentication = authenticationManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		
		MemberAccount mAccount = mAccountLoginService.readUser(username);
		
		return new AuthenticationToken(mAccount.getEmail(), mAccount.getAuthorities(), session.getId());
	}
	
	
	@GetMapping("/user")
	public String user(){
		
		return "HelloWorld";
	}
	
	
}
