package com.ian_avila.crud_client.controllers.handlers;

import com.ian_avila.crud_client.dto.CustomErrorResponse;
import com.ian_avila.crud_client.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse(Instant.now(), HttpStatus.UNPROCESSABLE_CONTENT.value(), "Invalid argument(s)", request.getRequestURI());
        e.getFieldErrors().forEach(response::add);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> databaseIntegrityViolated(DataIntegrityViolationException e, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse(Instant.now(), HttpStatus.CONFLICT.value(), "Operation not allowed: Data integrity violation", request.getRequestURI());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Invalid body request", request.getRequestURI());
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
