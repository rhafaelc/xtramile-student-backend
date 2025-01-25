package com.xtramile.studentcrud.infrastructure.student.dto;

import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.usecase.student.dto.DetailedStudentResponseDTO;
import com.xtramile.studentcrud.utils.DateUtils;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class DetailedStudentResponseDTOImpl implements DetailedStudentResponseDTO {
    @NotBlank()
    private final Long id;
    private final String fullName;
    private final String firstName;
    private final String lastName;
    private final LocalDate dob;
    private final int age;

    public DetailedStudentResponseDTOImpl(Student student) {
        this.id = student.getId();
        this.fullName = student.getFirstName() + " " + student.getLastName();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.dob = student.getDob();
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
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public LocalDate getDob() {
        return this.dob;
    }

    @Override
    public int getAge() {
        return this.age;
    }
} 