package com.cnc.chatservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSecurityConfiguration {

	@Bean
	public  InMemoryUserDetailsManager usersDetailsService() {
		// TODO: Retrieve username|password from database by 
		UserDetails user = User.withDefaultPasswordEncoder()
		.username("admin")
		.password("dangerous")
		.roles("USER")
		.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
			(requests) -> requests
				.anyRequest().authenticated()
		)
		.csrf( csrf -> csrf.disable())
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
}
