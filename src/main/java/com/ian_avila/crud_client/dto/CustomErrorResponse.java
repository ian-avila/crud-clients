package com.ian_avila.crud_client.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CustomErrorResponse {
    private Instant timestamp;
    private int status;
    private String error;
    private String path;
    private Map<String, String> errors = new HashMap<>();

    public CustomErrorResponse(Instant timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public void add(FieldError fieldError) {
        errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
