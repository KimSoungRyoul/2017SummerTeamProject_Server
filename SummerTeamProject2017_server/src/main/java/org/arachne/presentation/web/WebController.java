package org.arachne.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	
	@GetMapping(value="/test")
	public String asdfasdf(){
		
		return "/NewFile";
	}
	
}
