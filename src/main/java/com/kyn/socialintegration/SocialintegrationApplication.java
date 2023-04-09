package com.kyn.socialintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kyn.socialintegration.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SocialintegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialintegrationApplication.class, args);
	}

}
