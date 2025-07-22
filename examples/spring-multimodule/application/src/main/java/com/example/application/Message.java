package com.example.application;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Message {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;
    private String batchId;
    private Integer count;
    private String cargo;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
