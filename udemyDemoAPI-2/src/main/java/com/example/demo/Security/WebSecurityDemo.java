package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class WebSecurityDemo{

	private final UserService userDetailsService2;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityDemo(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService2 = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails john = org.springframework.security.core.userdetails.User.builder().username("John")
                .password("{noop}test123").roles("EMPLOYEE").build();

        UserDetails mary = org.springframework.security.core.userdetails.User.builder().username("Mary")
                .password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();

        UserDetails susan = org.springframework.security.core.userdetails.User.builder().username("Susan")
                .password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
                        configure
								.requestMatchers("/").hasRole("EMPLOYEE")
								.requestMatchers("/showMyLogInPage").hasRole("MANAGER")
                                .anyRequest().authenticated()
                );

		http.formLogin(form-> form
				.loginPage("/")
				.permitAll());
        return http.build();
		/**
		 * http.authorizeHttpRequests(configure ->
		 * 		configure
		 * 		.requestMatchers("/").hasRole("EMPLOYEE")
		 * 		.requestMatchers("/leaders/**").hasRole("MANAGER")
		 * 		.requestMatchers("/system/**").hasRole("ADMIN")
		 * 		.anyRequest().authenticated()
		 * 		)
		 * 		.formLogin(form-> form
		 * 				.loginPage("/showMyLogInPage")
		 * 				.loginProcessingUrl("/authenticateTheUser")
		 * 				.permitAll()
		 * 				).logout(logout -> logout.permitAll())
		 * 		.exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"));
		 * 		return http.build();
		 */
	}
}
