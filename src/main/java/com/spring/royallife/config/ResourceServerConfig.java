package com.spring.royallife.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/rest/**").permitAll()
		.antMatchers("/oauth/token").permitAll()
		.antMatchers("/api/rest/user/**").authenticated().anyRequest().access("hasAnyRole('USER')")
		.antMatchers("**/manager/**").authenticated().anyRequest().access("hasAnyRole('MANAGER')")
		.antMatchers("**/admin/**").authenticated().anyRequest().access("hasAnyRole('ADMIN')");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring()
         .antMatchers(HttpMethod.OPTIONS);
	}
}
