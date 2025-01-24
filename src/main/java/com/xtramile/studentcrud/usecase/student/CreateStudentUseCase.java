package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.usecase.student.dto.CreateStudentDTO;

public class CreateStudentUseCase {
    private final StudentGateway studentGateway;


    public CreateStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public Student execute(CreateStudentDTO input) {
        Student student = new Student(null, input.getFirstName(), input.getLastName(), input.getDob());
        return studentGateway.create(student);
    }
}
