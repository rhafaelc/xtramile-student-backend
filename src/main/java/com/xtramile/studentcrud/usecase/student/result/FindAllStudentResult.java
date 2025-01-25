package com.xtramile.studentcrud.usecase.student.result;

import com.xtramile.studentcrud.entity.student.model.Student;
import java.util.List;

public record FindAllStudentResult(
    List<Student> content,
    long totalElements,
    int number,
    int totalPages,
    int size,
    boolean empty
) {}
