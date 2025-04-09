package com.mag.apirest.api_rest_h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiRestH2Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestH2Application.class, args);
	}

}
