package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;

import java.util.List;

public class FindAllStudentUseCase {
    private final StudentGateway studentGateway;

    public FindAllStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public List<Student> execute(int page, int size) {
        return studentGateway.find(page, size);
    }
}
