package org.arachne.restapi;

import org.arachne.domain.testvo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/*") // /message/~~ 모든 url 관리
public class Test2Controller {
	
	
	@RequestMapping(value= "/send", method=RequestMethod.GET)
	public User restTest(@RequestBody User user){
		
		
		
		user.setId("asadf");
		user.setPassword("12345");
		
		
		
		return user;
	}

}
