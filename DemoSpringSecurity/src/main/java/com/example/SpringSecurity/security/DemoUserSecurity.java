//package com.example.SpringSecurity.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer.ConcurrencyControlConfigurer;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class DemoUserSecurity {
//
//	@Bean
//	public UserDetailsManager userDetailsManager(DataSource data) {
//
//		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(data);
//
//		userDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
//		userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
//
//		return userDetailsManager;
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(configurer ->
//		configurer
//		.requestMatchers("/").hasRole("EMPLOYEE")
//		.requestMatchers("/leaders/**").hasRole("MANAGER")
//		.requestMatchers("/system/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		)
//		.formLogin(form-> form
//				.loginPage("/showMyLogInPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//				).logout(logout -> logout.permitAll())
//		.exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"));
//		return http.build();
//
//	}
//	/* We save this data in DB and lets JdbcUserDetailsManager handle the rest for us
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails john = org.springframework.security.core.userdetails.User.builder().username("John")
//				.password("{noop}test123").roles("EMPLOYEE").build();
//
//		UserDetails mary = org.springframework.security.core.userdetails.User.builder().username("Mary")
//				.password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
//
//		UserDetails susan = org.springframework.security.core.userdetails.User.builder().username("Susan")
//				.password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//		return new InMemoryUserDetailsManager(john, mary, susan);
//	}
//	*/
//
//}
