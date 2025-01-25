package com.xtramile.studentcrud.infrastructure.student.dto;

import com.xtramile.studentcrud.usecase.student.dto.UpdateStudentDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UpdateStudentDTOImpl implements UpdateStudentDTO {
    @NotBlank(message = "First name is required")
    private final String firstName;

    @NotBlank(message = "Last name is required")
    private final String lastName;

    @NotNull(message = "Date of Birth is required")
    private final LocalDate dob;

    public UpdateStudentDTOImpl(String firstname, String lastname, LocalDate dob) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.dob = dob;
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
}
