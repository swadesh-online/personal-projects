package com.personal.okta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*@EnableWebSecurity*/
public class SecurityConfig 
//extends WebSecurityConfigurerAdapter
{
	/*
	 * for basic in memory authentication
	 * 
	 * 
	 * private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder())
	 * .withUser("swadesh") .password(passwordEncoder().encode("secret"))
	 * .roles("USER"); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return passwordEncoder; }
	 */}

