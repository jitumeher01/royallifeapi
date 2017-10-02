package com.spring.royallife.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class RestConfig extends WebMvcConfigurerAdapter{

	 @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("OPTIONS");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("DELETE");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	 
	    @Override
		public void addCorsMappings(CorsRegistry registry) {
			 registry.addMapping("/api/**")
		   	  .allowedOrigins("http://localhost:4200", "http://127.0.0.1:4200","http://localhost:3000", "http://127.0.0.1:3000","http://localhost", "http://127.0.0.1","http://localhost:80", "http://127.0.0.1:80","http://www.learnplanet.in","http://learnplanet.in")
			  .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
			  .allowedHeaders("token", "Content-Type")
			  .allowCredentials(false)
			  .maxAge(4800);
		}
	
}
