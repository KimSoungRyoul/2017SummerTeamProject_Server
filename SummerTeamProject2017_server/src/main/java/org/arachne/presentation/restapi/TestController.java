package org.arachne.presentation.restapi;

import org.arachne.util.GcmCcsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
 
    //@Autowired
    private GcmCcsSender mGcmCcsSender;
 
    @RequestMapping(value = "/{registrationId}", method = RequestMethod.GET)
    public void monsters(@PathVariable("registrationId") String registrationId) {
        String message = "TEST MESSAGE";
 
        mGcmCcsSender.send(registrationId, message);
    }
}