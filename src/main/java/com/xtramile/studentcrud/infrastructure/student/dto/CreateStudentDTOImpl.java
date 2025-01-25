package com.xtramile.studentcrud.infrastructure.student.dto;

import com.xtramile.studentcrud.usecase.student.dto.CreateStudentDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateStudentDTOImpl implements CreateStudentDTO {
        @NotBlank(message = "First name is required")
        private final String firstName;

        @NotBlank(message = "Last name is required")
        private final String lastName;

        @NotNull(message = "Date of Birth is required")
        private final LocalDate dob;

        public CreateStudentDTOImpl(String firstName, String lastName, LocalDate dob) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.dob = dob;
        }

        @Override
        public String firstName() {
                return this.firstName;
        }

        @Override
        public String lastName() {
                return this.lastName;
        }

        @Override
        public LocalDate dob() {
                return this.dob;
        }
}
