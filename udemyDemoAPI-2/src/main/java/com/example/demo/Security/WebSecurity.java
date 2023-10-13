package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.ws.Service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfiguration{
	
	private final UserService userDetailsService2;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService2 = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("tushar")
								.password(encoder
								.encode("1111"))
								.roles("ADMIN")
								.build();
		UserDetails job = User.withUsername("ajay")
							  .password(encoder.encode("1111"))
							  .roles("USER")
							  .build();
	
		return new InMemoryUserDetailsManager(admin,job);
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
		
//		AuthenticationManagerBuilder authenticationManagerBuilder =
//				http.getSharedObject(AuthenticationManagerBuilder.class);
//		
////		authenticationManagerBuilder.userDetailsService(userDetailsService)
////		.passwordEncoder(bCryptPasswordEncoder);
//
////		AuthenticationManager authenticationManager =authenticationManagerBuilder.build();
////		http.authenticationManager(authenticationManager);

		
		
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/users").permitAll()
		.and().authorizeHttpRequests().
		requestMatchers("/").authenticated().and().formLogin();
 
		
		return http.build();
		
	}
}
