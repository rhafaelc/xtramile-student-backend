package com.xtramile.studentcrud.infrastructure.student.dto;

import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.usecase.student.dto.StudentResponseDTO;
import com.xtramile.studentcrud.utils.DateUtils;
import jakarta.validation.constraints.NotBlank;

public class StudentResponseDTOImpl implements StudentResponseDTO {
    @NotBlank()
    private final Long id;
    private final String fullName;
    private final int age;

    public StudentResponseDTOImpl(Student student) {
        String fullName = student.getFirstName();
        if (student.getLastName() != null) {
            fullName += " " + student.getLastName();
        }

        this.id = student.getId();
        this.fullName = fullName;
        this.age = DateUtils.calculateAge(student.getDob());
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
