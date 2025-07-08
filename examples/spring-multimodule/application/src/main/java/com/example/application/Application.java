package com.example.application;

import com.example.library.component.SimpleComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.example")
@RestController
public class Application {

	private final SimpleComponent simpleComponent;

	public Application(SimpleComponent simpleComponent) {
		this.simpleComponent = simpleComponent;
	}

	@GetMapping("/")
	public String home() {
		return simpleComponent.message();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
