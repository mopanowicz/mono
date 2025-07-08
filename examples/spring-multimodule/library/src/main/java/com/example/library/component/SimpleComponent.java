package com.example.library.component;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(SimpleComponentProperties.class)
public class SimpleComponent {

	private final SimpleComponentProperties componentProperties;

	public SimpleComponent(SimpleComponentProperties componentProperties) {
		this.componentProperties = componentProperties;
	}

	public String message() {
		return this.componentProperties.getMessage();
	}
}
