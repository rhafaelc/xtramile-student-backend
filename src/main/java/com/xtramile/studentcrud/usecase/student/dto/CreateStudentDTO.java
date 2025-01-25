package com.xtramile.studentcrud.usecase.student.dto;

import java.time.LocalDate;

public interface CreateStudentDTO {
    String firstName();
    String lastName();
    LocalDate dob();
}
