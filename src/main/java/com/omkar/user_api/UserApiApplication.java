package com.omkar.user_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
		return factory -> {
			// Dynamically set the port from the PORT environment variable
			String port = System.getenv("PORT");
			if (port != null) {
				factory.setPort(Integer.parseInt(port));
			} else {
				factory.setPort(8080); // Default to port 8080 if PORT is not set
			}
		};
	}
}
