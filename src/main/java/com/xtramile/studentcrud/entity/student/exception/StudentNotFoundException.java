package com.xtramile.studentcrud.entity.student.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found");
    }
}
