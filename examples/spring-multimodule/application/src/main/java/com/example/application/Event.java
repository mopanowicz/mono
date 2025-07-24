package com.example.application;

import com.example.commons.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Event {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;
    private String batchId;
    private Integer count;
    private String cargo;

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
