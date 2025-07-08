package com.example.library.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("simple-component.message=Hello")
public class SimpleComponentTest {

	@Autowired
	private SimpleComponent simpleComponent;

	@Test
	public void contextLoads() {
		assertThat(simpleComponent.message()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
