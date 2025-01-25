package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;

public class FindStudentByIdUseCase {
    private final StudentGateway studentGateway;

    public FindStudentByIdUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public Student execute(Long id) {
        return studentGateway.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }
} 