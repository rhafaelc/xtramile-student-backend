package com.xtramile.studentcrud.infrastructure.config.exception;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorData> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorData(
                        error.getField(),
                        Collections.singletonList(error.getDefaultMessage())
                ))
                .toList();

        String errorMessage = "Validation failed: " + validationErrors.stream()
                .map(error -> error.field() + ": " + String.join(", ", error.messages()))
                .collect(Collectors.joining("; "));

        return ResponseEntity
            .badRequest()
            .body(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiResponse.error(HttpStatus.NOT_FOUND.value(), "Student not found"));
    }

    private record ValidationErrorData(String field, List<String> messages) {
        public ValidationErrorData(FieldError erro) {
            this(erro.getField(), new ArrayList<>(Collections.singletonList(erro.getDefaultMessage())));
        }
    }
}
