package com.practice.FoodDelivery.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder()
				.username("admin")
				.password(new BCryptPasswordEncoder().encode("admin123"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.builder()
				.username("user")
				.password(new BCryptPasswordEncoder().encode("user123"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}

}
