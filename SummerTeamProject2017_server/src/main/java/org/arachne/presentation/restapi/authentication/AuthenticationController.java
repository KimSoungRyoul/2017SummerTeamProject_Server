package org.arachne.presentation.restapi.authentication;

import javax.servlet.http.HttpSession;

import org.arachne.application.MemberAccountLoginService;
import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.dto.AuthenticationDTO;
import org.arachne.domain.dto.AuthenticationToken;
import org.arachne.infrastructure.repository.mariadb.MemberAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	MemberAccountLoginService mAccountLoginService;

	@Autowired
	MemberAccountRepository mRepository;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public AuthenticationToken login(@RequestBody AuthenticationDTO authenticationRequest, HttpSession session) {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		
		
		
		Authentication authentication = authenticationManager.authenticate(token);
		
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		MemberAccount user = (MemberAccount) mAccountLoginService.loadUserByUsername(username);
		
		log.info(user.getEmail()+"----------------------------");
		
		return new AuthenticationToken(user.getEmail(), user.getAuthorities2(), session.getId());
	}

	@GetMapping("/user")
	public String user() {

		log.info("/user 접속 성공");

		return "HelloWorld";
	}

	@PostMapping
	public String signUp(@RequestBody MemberAccount account) throws Exception {

		mAccountLoginService.registerMemberAccount(account);

		return "SUCCESS";

	}

}
