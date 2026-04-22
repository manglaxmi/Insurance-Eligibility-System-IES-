package com.IES.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.IES.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	private final JwtAuthenticationFilter jwtFilter;
	private final AuthenticationProvider authProvider;

	public SecurityConfig(JwtAuthenticationFilter jwtFilter, AuthenticationProvider authProvider) {
		this.jwtFilter = jwtFilter;
		this.authProvider = authProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/ies/v1/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
								.anyRequest().authenticated())
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}