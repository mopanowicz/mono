package com.example.library.component;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(SimpleComponentConfig.class)
public class SimpleComponent {

	private final SimpleComponentConfig componentProperties;

	public SimpleComponent(SimpleComponentConfig componentProperties) {
		this.componentProperties = componentProperties;
	}

	public String message() {
		return this.componentProperties.getMessage();
	}
}
