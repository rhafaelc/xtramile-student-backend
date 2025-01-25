package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.infrastructure.student.dto.PaginatedStudentResponseDTOImpl;
import com.xtramile.studentcrud.infrastructure.student.dto.StudentResponseDTOImpl;
import com.xtramile.studentcrud.usecase.student.FindAllStudentUseCase;
import com.xtramile.studentcrud.usecase.student.dto.StudentResponseDTO;
import com.xtramile.studentcrud.usecase.student.result.FindAllStudentResult;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FindStudentController {
    private final FindAllStudentUseCase findAllStudentUseCase;

    public FindStudentController(FindAllStudentUseCase findAllStudentUseCase) {
        this.findAllStudentUseCase = findAllStudentUseCase;
    }

    @GetMapping("/students")
    public ApiResponse<PaginatedStudentResponseDTOImpl> findStudent(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "Page must be greater than 1") int page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be greater than 1") int size
    ) {
        FindAllStudentResult result = findAllStudentUseCase.execute(page - 1, size);

        List<StudentResponseDTO> formattedResults = result.content().stream()
                .map(StudentResponseDTOImpl::new)
                .collect(Collectors.toList());
                
        PaginatedStudentResponseDTOImpl response = new PaginatedStudentResponseDTOImpl(
            formattedResults,
            result.totalElements(),
            result.number() + 1,
            result.totalPages(),
            result.size(),
            result.empty()
        );

        return ApiResponse.success("Students retrieved successfully", response);
    }
}
