package org.arachne.config;

import org.arachne.application.MemberAccountLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

				/*.authorizeRequests().antMatchers("/").permitAll()
				.and()*/
				.authorizeRequests().antMatchers("/api/login").permitAll()

				.antMatchers("/user/**").hasAuthority("ROLE_NORMAL_USER")

				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")

				.antMatchers("/projectmanagement/**").hasAuthority("ROLE_PROJECT_LEADER")

				.anyRequest().authenticated().and()

				.formLogin().and()

				.logout();

	}

	/*@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}*/

	/* @Override
	  public void configure(WebSecurity web) throws Exception {
	      //spring security 제외 경로설정 
		  web.ignoring()
		  .antMatchers("/resources/**")
		  .antMatchers("/v2/api-docs", "/configuration/ui",

                  "/swagger-resources/**", "/configuration/security",

                  "/swagger-ui.html", "/webjars/**","/swagger/**");
	  }
	*/
	

	 
	/*@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}*/

}
