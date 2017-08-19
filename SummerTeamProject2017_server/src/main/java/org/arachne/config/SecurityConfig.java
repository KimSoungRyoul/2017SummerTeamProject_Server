package org.arachne.config;

import org.arachne.application.MemberAccountLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MemberAccountLoginService mAccountService;

	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http 
			.csrf()
			.disable() 
			.authorizeRequests() 
			.antMatchers("/user/login")
			.permitAll() 
			.antMatchers("/user")
			.hasAuthority("NORMAL_USER") 
			.antMatchers("/admin")
			.hasAuthority("ADMIN")
			.antMatchers("/projectmanagement")
			.hasAuthority("PROJECT_LEADER")
			.anyRequest()
			.authenticated()
			.and() 
			
			//.formLogin()
			//	 .and()
		
			.logout();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(mAccountService).passwordEncoder(mAccountService.passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
