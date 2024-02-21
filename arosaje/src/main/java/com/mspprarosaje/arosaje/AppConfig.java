package com.mspprarosaje.arosaje;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Value(value = "${pictures.path}")
	private String picturesPathProperty;

	@Bean
	public String picturesPath() {
		return picturesPathProperty;
	}
}
