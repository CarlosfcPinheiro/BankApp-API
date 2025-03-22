package me.dio.api_rest_springboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotations to OpenAPI swagger and Spring root class Spring Application
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class Application {
	// Main start method
	public static void main(String[] args) {
		// Run static method .run() with literal Application class and args
		SpringApplication.run(Application.class, args);
	}
}