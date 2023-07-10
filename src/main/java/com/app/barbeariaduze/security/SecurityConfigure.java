package com.app.barbeariaduze.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests((authorize) -> authorize
			.requestMatchers(HttpMethod.GET, "/").permitAll()
			.anyRequest().authenticated()
		 )
			
		 .formLogin()
		 	.loginPage("/login")
		 	.defaultSuccessUrl("/index", true)
		 	.failureUrl("/login")
		 	.permitAll()
		 .and()
		 	.logout()
		 	.logoutSuccessUrl("/login")
		 	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsServiceImpl) throws Exception {
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsServiceImpl)
				.passwordEncoder(passwordEncoder)
				.and()
				.build();
	}
	
}
