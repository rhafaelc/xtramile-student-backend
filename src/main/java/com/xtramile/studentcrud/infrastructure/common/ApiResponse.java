package com.xtramile.studentcrud.infrastructure.common;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private final int statusCode;
    private final String message;
    private final T payload;

    private ApiResponse(int statusCode, String message, T payload) {
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }

    public static <T> ApiResponse<T> success(String message, T payload) {
        return new ApiResponse<>(HttpStatus.OK.value(), message, payload);
    }

    public static ApiResponse<Void> success(String message) {
        return new ApiResponse<>(HttpStatus.OK.value(), message, null);
    }

    public static <T> ApiResponse<T> created(String message, T payload) {
        return new ApiResponse<>(HttpStatus.CREATED.value(), message, payload);
    }

    public static ApiResponse<Void> error(int statusCode, String message) {
        return new ApiResponse<>(statusCode, message, null);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getPayload() {
        return payload;
    }
} 