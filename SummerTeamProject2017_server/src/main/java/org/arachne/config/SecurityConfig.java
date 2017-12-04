package org.arachne.config;

import org.arachne.application.MemberAccountLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MemberAccountLoginService userDetailService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()

		
				//.httpBasic()
				//.and()
				
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
				
				
				
				.authorizeRequests().antMatchers("/api/login").permitAll()
				.antMatchers("/").permitAll()

			
				
				.antMatchers("/user/**")
				.hasAuthority("ROLE_NORMAL_USER")

				.antMatchers("/admin/**")
				.hasAuthority("ROLE_ADMIN")

				.antMatchers("/projectmanagement/**")
				.hasAuthority("ROLE_PROJECT_LEADER")

				.antMatchers(HttpMethod.POST, "/projects")
				.hasAuthority("ROLE_MORMAL_USER")
				

				
				
				.anyRequest()
				.authenticated()
				
				
				.and()

				
				
				/*.formLogin()
				.and()*/

				.logout()
				.and()
				
				.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler("/error"))
				
				;

	}

	/*@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}*/

	
	
	
	 @Override
	  public void configure(WebSecurity web) throws Exception {
	      //spring security 제외 경로설정 
		  web.ignoring()
		  .antMatchers("/static/**")
		  .antMatchers("/error/**")
		  .antMatchers("/swagger-ui.html")
		  .antMatchers("/webjars/**")
		  .antMatchers("/swagger-resources/**")
		  .antMatchers("/v2/api-docs");
	  }
	
	

	 
	/*@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}*/

}
