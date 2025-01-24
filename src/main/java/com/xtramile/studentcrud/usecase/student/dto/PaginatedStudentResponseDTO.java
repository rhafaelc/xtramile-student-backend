package com.xtramile.studentcrud.usecase.student.dto;

import java.util.List;

public interface PaginatedStudentResponseDTO {
    int getCount();
    String getPrev();
    String getNext();
    List<StudentResponseDTO> getResults();
}