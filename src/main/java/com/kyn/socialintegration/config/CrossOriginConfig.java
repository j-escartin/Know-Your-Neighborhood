package com.kyn.socialintegration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {


	@Override
	  public void addCorsMappings(CorsRegistry registry) {
	    WebMvcConfigurer.super.addCorsMappings(registry);
	    registry
	        .addMapping("/**")
	        .allowedOriginPatterns("*")
	        .allowedHeaders("*")
	        .allowedMethods("GET", "POST", "PUT", "DELETE")
	        .allowCredentials(true);
	  }
}
