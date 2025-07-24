package com.example.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("local.logging.kafka-event-logger")
public class KafkaEventLoggerConfig {

    private final Map<String, String> properties = new HashMap<>();
    private String topic;
    private boolean errorToSystemOut = true;

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties.putAll(properties);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isErrorToSystemOut() {
        return errorToSystemOut;
    }

    public void setErrorToSystemOut(boolean errorToSystemOut) {
        this.errorToSystemOut = errorToSystemOut;
    }

}
