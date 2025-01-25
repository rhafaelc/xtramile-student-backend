package com.xtramile.studentcrud.infrastructure.student.dto;

import com.xtramile.studentcrud.usecase.student.dto.PaginatedStudentResponseDTO;
import com.xtramile.studentcrud.usecase.student.dto.StudentResponseDTO;

import java.util.List;

public class PaginatedStudentResponseDTOImpl implements PaginatedStudentResponseDTO {
    private final List<StudentResponseDTO> content;
    private final Metadata metadata;

    public PaginatedStudentResponseDTOImpl(
            List<StudentResponseDTO> content,
            long totalElements,
            int page,
            int totalPages,
            int size,
            boolean empty
    ) {
        this.content = content;
        this.metadata = new MetadataImpl(totalElements, page, totalPages, size, empty);
    }

    @Override
    public List<StudentResponseDTO> getContent() {
        return this.content;
    }

    @Override
    public Metadata getMetadata() {
        return this.metadata;
    }

    private static class MetadataImpl implements Metadata {
        private final long totalElements;
        private final int page;
        private final int totalPages;
        private final int size;
        private final boolean empty;

        MetadataImpl(long totalElements, int page, int totalPages, int size, boolean empty) {
            this.totalElements = totalElements;
            this.page = page;
            this.totalPages = totalPages;
            this.size = size;
            this.empty = empty;
        }

        @Override
        public long getTotalElements() { return totalElements; }
        @Override
        public int getPage() { return page; }
        @Override
        public int getTotalPages() { return totalPages; }
        @Override
        public int getSize() { return size; }
        @Override
        public boolean isEmpty() { return empty; }
    }
}
