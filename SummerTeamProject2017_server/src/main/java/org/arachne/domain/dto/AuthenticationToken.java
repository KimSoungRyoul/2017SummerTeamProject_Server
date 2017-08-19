package org.arachne.domain.dto;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import lombok.Data;


@Data
public class AuthenticationToken {
    
     private String username;
     private Collection<?> authorities;
     private String token;
    
     public AuthenticationToken(String username, Collection<?> collection, String token) {
          this.username = username;
          this.authorities = collection;
          this.token = token;
     }

     @Override
     public String toString() {
         return ToStringBuilder
             .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
     }
}