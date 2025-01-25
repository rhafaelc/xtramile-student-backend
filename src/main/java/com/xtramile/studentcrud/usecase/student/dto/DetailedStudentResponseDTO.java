package com.xtramile.studentcrud.usecase.student.dto;

import java.time.LocalDate;

public interface DetailedStudentResponseDTO {
    Long getId();
    String getFullName();
    String getFirstName();
    String getLastName();
    LocalDate getDob();
    int getAge();
} 