package com.xtramile.studentcrud.usecase.student.dto;

import java.util.List;

public interface PaginatedStudentResponseDTO {
    List<StudentResponseDTO> getContent();
    Metadata getMetadata();
    
    interface Metadata {
        long getTotalElements();
        int getPage();
        int getTotalPages();
        int getSize();
        boolean isEmpty();
    }
}