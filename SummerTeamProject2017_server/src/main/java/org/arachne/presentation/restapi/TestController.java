package org.arachne.presentation.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;



@Api(value="Hello Swagger Friend")
@RestController
@RequestMapping(value="/api")
public class TestController {
 
   
    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String monsters() {
        String message = "TEST MESSAGE";
 
      //  mGcmCcsSender.send(registrationId, message);
   
        return message;
    }
    
    @GetMapping("/bbb")
    public String asdf(){
    	
    	
    	return "hello swagger111";
    }
    
    
 
    
}