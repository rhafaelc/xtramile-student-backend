package com.xtramile.studentcrud.usecase.student;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.usecase.student.dto.UpdateStudentDTO;

public class UpdateStudentUseCase {
    private final StudentGateway studentGateway;

    public UpdateStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    public Student execute(Long id, UpdateStudentDTO input) {
        Student existingStudent = studentGateway.findById(id).orElseThrow(StudentNotFoundException::new);

        existingStudent.setFirstName(input.getFirstName());
        existingStudent.setLastName(input.getLastName());
        existingStudent.setDob(input.getDob());

        return studentGateway.update(existingStudent);
    }
}
