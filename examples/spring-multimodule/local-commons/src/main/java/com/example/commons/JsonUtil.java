package com.example.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    static {
        objectMapper.findAndRegisterModules();
    }

    public static String toJsonString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            try {
                return objectMapper.writeValueAsString(new Error(e.getMessage()));
            } catch (JsonProcessingException impossible) {
                return null;
            }
        }
    }
}
