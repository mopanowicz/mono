package com.example.application;

import com.example.library.component.SimpleComponent;
import com.example.logging.KafkaEventLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication(scanBasePackages = "com.example")
@RestController
public class Application {

	private final SimpleComponent simpleComponent;
	private final KafkaEventLogger kafkaEventLogger;
	private final AtomicInteger count = new AtomicInteger();

	private final String batchId = String.valueOf(UUID.randomUUID());

	public Application(SimpleComponent simpleComponent, KafkaEventLogger kafkaEventLogger) {
		this.simpleComponent = simpleComponent;
		this.kafkaEventLogger = kafkaEventLogger;
	}

	@GetMapping("/")
	Message home() {
		Message message = new Message();
		message.setTimestamp(LocalDateTime.now());
		message.setBatchId(batchId);
		message.setCount(count.getAndIncrement());
		message.setCargo(simpleComponent.message());
		kafkaEventLogger.logEvent(message);
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
