package com.example.logging;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@EnableConfigurationProperties(KafkaEventLoggerConfig.class)
public class KafkaEventLogger {

    private final Logger log = LoggerFactory.getLogger(KafkaEventLogger.class);

    private final KafkaEventLoggerConfig config;
    private final Producer<Object, Object> producer;

    public KafkaEventLogger(KafkaEventLoggerConfig config) {
        this.config = config;
        Map<String, Object> configs = new HashMap<>(config.getProperties());
        ProducerFactory<Object, Object> producerFactory = new DefaultKafkaProducerFactory<>(configs);
        this.producer = producerFactory.createProducer();
    }

    public void logEvent(Object event) {
        final ProducerRecord<Object, Object> producerRecord = new ProducerRecord<>(config.getTopic(), null, event);
        producer.send(producerRecord, (metadata, exception) -> {
            if (exception == null) {
                log.info("Sent timestamp={}", metadata.timestamp());
            } else {
                handleProducerRecordError(producerRecord, exception);
            }
        });
    }

    protected void handleProducerRecordError(ProducerRecord<Object, Object> producerRecord, Throwable e) {
        log.error("Error while sending producer record {}", producerRecord, e);
    }
}
