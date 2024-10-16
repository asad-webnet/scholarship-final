package com.finalproject.scholarship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ScholarshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScholarshipApplication.class, args);
	}

}
