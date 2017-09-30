package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.royallife.repository.UserRepository;


@SpringBootApplication
public class RoyallifeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RoyallifeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RoyallifeApplication.class);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
       builder.userDetailsService(new UserDetailsService() {
		@Override
		public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
			
			return new CustomUserDetails(repository.findByUserId(userId));
		}
	});
	}
	
	
}
