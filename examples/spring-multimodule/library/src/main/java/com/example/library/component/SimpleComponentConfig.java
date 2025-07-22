package com.example.library.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("simple-component")
public class SimpleComponentConfig {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
