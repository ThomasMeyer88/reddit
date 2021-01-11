package com.reddit.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().
				authorizeRequests().
				antMatchers(HttpMethod.POST, "/user/create").permitAll().
				antMatchers(HttpMethod.GET, "/user/all").permitAll().
				antMatchers(HttpMethod.DELETE,"/user/delete/**").permitAll().
				antMatchers(HttpMethod.OPTIONS, "/**").permitAll().
				anyRequest().authenticated()
				.and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("javainuse").password("{noop}password").roles("");
	}
}
