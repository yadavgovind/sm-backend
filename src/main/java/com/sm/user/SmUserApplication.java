package com.sm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sm.user"})
public class SmUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmUserApplication.class, args);
	}

}
