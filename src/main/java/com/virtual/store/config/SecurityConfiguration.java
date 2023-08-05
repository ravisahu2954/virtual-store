//package com.virtual.store.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring()
//				// Spring Security should completely ignore URLs starting with /resources/
//				.requestMatchers("/resources/**");
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	
//		
//		
//		
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		 UserDetails user = User.withUsername("rav").password("python123").build();
//		UserDetails admin = User.withUsername("admin").password("password")
//				.roles("ADMIN", "USER").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//}
