package com.xtramile.studentcrud.infrastructure.config.exception;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();

        List<ValidationErrorData> validationErrors = fieldErrors.stream()
                .collect(Collectors.groupingBy(FieldError::getField)) // Group by field
                .entrySet().stream()
                .map(entry -> new ValidationErrorData(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.toList())
                ))
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");
        response.put("details", validationErrors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }

    private record ValidationErrorData(String field, List<String> messages) {
        public ValidationErrorData(FieldError erro) {
            this(erro.getField(), new ArrayList<>(Collections.singletonList(erro.getDefaultMessage())));
        }
    }
}
