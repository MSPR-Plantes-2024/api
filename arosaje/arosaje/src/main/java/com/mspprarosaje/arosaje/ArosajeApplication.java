package com.mspprarosaje.arosaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mspprarosaje")
public class ArosajeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArosajeApplication.class, args);
	}

}

