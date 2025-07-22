package com.example.application;

import com.example.library.component.SimpleComponent;
import com.example.logging.KafkaEventLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication(scanBasePackages = "com.example")
@RestController
public class Application {

	private final Logger log = LoggerFactory.getLogger(Application.class);

	private final SimpleComponent simpleComponent;

	private final KafkaEventLogger kafkaEventLogger;

	private final AtomicInteger count = new AtomicInteger();

	public Application(SimpleComponent simpleComponent, KafkaEventLogger kafkaEventLogger) {
		this.simpleComponent = simpleComponent;
		this.kafkaEventLogger = kafkaEventLogger;
	}

	@GetMapping("/")
	public String home() {
		String message = simpleComponent.message();
		kafkaEventLogger.logEvent(message);
//		log.info("home message={}", message);
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
