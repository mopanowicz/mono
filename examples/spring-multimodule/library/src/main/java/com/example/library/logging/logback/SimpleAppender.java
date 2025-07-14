package com.example.library.logging.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(SimpleAppenderProperties.class)
public class SimpleAppender extends AppenderBase<ILoggingEvent> implements ApplicationContextAware {

    private static SimpleAppenderProperties simpleAppenderProperties;

    @Override
    protected void append(ILoggingEvent event) {
        String prefix = simpleAppenderProperties == null ? "-" : simpleAppenderProperties.getPrefix();
        System.out.println(prefix + event.getFormattedMessage());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        simpleAppenderProperties = applicationContext.getAutowireCapableBeanFactory().getBean(SimpleAppenderProperties.class);
    }
}