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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;



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

		
				.httpBasic()
				.and()
				
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()

				.authorizeRequests().antMatchers("/login").permitAll()

				.antMatchers("/user").hasAuthority("ROLE_NORMAL_USER")

				.antMatchers("/admin").hasAuthority("ROLE_ADMIN")

				.antMatchers("/projectmanagement").hasAuthority("ROLE_PROJECT_LEADER")

				.anyRequest().authenticated().and()

				//.formLogin().and()

				.logout();

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/*@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}*/

}
