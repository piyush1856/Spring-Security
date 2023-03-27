package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.requestMatchers(HttpMethod.POST, "/customers").permitAll()  // to call this endpoint don,t ask for any username or password
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable()  // to enable all post/put request : by default it is enabled
			.formLogin()
			.and()
			.httpBasic();

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}