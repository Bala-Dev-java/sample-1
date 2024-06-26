package com.application1.userlogin.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class Securityconfig {
	
		@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			return http.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
					.build();
		}
	
//	@Bean
//	public UserDetailsService UserDetailsService()
//	{
//		UserDetails user1 = User.withUsername("User1")
//				.password("{noop}user1@1234")
//				.roles("USER")
//				.build();
//		
//		UserDetails admin = User.withUsername("admin")
//				.password("{noop}admin@1234")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user1, admin);
//	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	

}
