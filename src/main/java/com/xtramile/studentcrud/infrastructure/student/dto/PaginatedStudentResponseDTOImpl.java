package com.xtramile.studentcrud.infrastructure.student.dto;


import com.xtramile.studentcrud.usecase.student.dto.PaginatedStudentResponseDTO;
import com.xtramile.studentcrud.usecase.student.dto.StudentResponseDTO;

import java.util.List;

public class PaginatedStudentResponseDTOImpl implements PaginatedStudentResponseDTO {
    private final int count;
    private final String prev;
    private final String next;
    private final List<StudentResponseDTO> results;

    public PaginatedStudentResponseDTOImpl(int count, String prev, String next, List<StudentResponseDTO> results) {
        this.count = count;
        this.prev = prev;
        this.next = next;
        this.results = results;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public String getPrev() {
        return this.prev;
    }

    @Override
    public String getNext() {
        return this.next;
    }

    @Override
    public List<StudentResponseDTO> getResults() {
        return this.results;
    }
}
