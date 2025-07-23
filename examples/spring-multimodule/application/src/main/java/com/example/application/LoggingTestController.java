package com.example.application;

import com.example.logging.KafkaEventLogger;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class LoggingTestController {

    private final KafkaEventLogger kafkaEventLogger;

    private final AtomicInteger count = new AtomicInteger();
    private final String batchId = String.valueOf(UUID.randomUUID());

    @GetMapping("/log-event")
    Event logEvent() {
        Event event = new Event();
        event.setTimestamp(LocalDateTime.now());
        event.setBatchId(batchId);
        event.setCount(count.getAndIncrement());
        event.setCargo(RandomStringUtils.secure().next(64, true, true));
        kafkaEventLogger.logEvent(event);
        return event;
    }
}
