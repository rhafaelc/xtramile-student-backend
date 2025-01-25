package com.xtramile.studentcrud.usecase.student.dto;

import java.time.LocalDate;

public interface UpdateStudentDTO {
    String getFirstName();
    String getLastName();
    LocalDate getDob();
}
