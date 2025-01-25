package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;

public class DeleteStudentUseCase {
    private final StudentGateway studentGateway;

    public DeleteStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public void execute(Long id) {
        studentGateway.findById(id).orElseThrow(StudentNotFoundException::new);
        studentGateway.delete(id);
    }
}
