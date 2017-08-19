package org.arachne.util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

//@Component
@Log4j
public class GcmCcsSender {
 
   // private static final Logger LOG = LoggerFactory.getLogger(GcmCcsSender.class);
 
    private static final String senderId = "ksr5367";
    private static final String password = "AIzaSyCeYnykEJrXWTKipfwdgBVbo8svn2zld84";
    private SmackCcsClient mCssClient = new SmackCcsClient();
 
    @PostConstruct
    public void init() {
        try {
            mCssClient.connect(senderId, password);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
 
    @Async
    public void send(String registrationId, String message) {
        try {
            Map<String,String> payload = new HashMap<String, String>();
            payload.put("msg", message);
 
            String jsonMessage = mCssClient.createJsonMessage(registrationId, mCssClient.nextMessageId(), payload, "", 10000L, true);
            mCssClient.sendDownstreamMessage(jsonMessage);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
}