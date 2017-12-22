package org.arachne.presentation.restapi;

import java.util.HashMap;
import java.util.Map;

import org.arachne.domain.dto.HttpStateDTOFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorAPI {

	
	
	@GetMapping("/403")
	public ResponseEntity<Map<String, Object>> notFobidden403Error(){
		
		ResponseEntity<Map<String, Object>> response=null;
		Map<String, Object> result=new HashMap<>();
		
		result.put("state", HttpStateDTOFactory.get401());
		
		response=new ResponseEntity<Map<String, Object>>(result,HttpStatus.NOT_ACCEPTABLE);
		
		
		
		return response;
		
	}
	
}
