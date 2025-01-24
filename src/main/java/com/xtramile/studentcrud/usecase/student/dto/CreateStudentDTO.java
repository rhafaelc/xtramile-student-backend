package com.xtramile.studentcrud.usecase.student.dto;

import java.time.LocalDate;

public interface CreateStudentDTO {
    String getFirstName();
    String getLastName();
    LocalDate getDob();
}
