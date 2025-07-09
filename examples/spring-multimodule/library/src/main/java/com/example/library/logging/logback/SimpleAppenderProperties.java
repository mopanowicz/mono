package com.example.library.logging.logback;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("local.logging.logback.simple-appender")
public class SimpleAppenderProperties {

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
