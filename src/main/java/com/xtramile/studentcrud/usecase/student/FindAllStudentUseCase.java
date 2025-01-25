package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.usecase.student.result.FindAllStudentResult;

import java.util.List;

public class FindAllStudentUseCase {
    private final StudentGateway studentGateway;

    public FindAllStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public FindAllStudentResult execute(int page, int size) {
        List<Student> students = studentGateway.find(page, size);
        long totalElements = studentGateway.count();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        return new FindAllStudentResult(
            students,
            totalElements,
            page,
            totalPages,
            size,
            students.isEmpty()
        );
    }
}
