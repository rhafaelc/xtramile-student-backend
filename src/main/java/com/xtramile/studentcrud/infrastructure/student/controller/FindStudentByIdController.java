package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.infrastructure.student.dto.DetailedStudentResponseDTOImpl;
import com.xtramile.studentcrud.usecase.student.FindStudentByIdUseCase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FindStudentByIdController {
    private final FindStudentByIdUseCase findStudentByIdUseCase;

    public FindStudentByIdController(FindStudentByIdUseCase findStudentByIdUseCase) {
        this.findStudentByIdUseCase = findStudentByIdUseCase;
    }

    @GetMapping("/students/{id}")
    public ApiResponse<DetailedStudentResponseDTOImpl> findStudentById(@PathVariable Long id) {
        DetailedStudentResponseDTOImpl response = new DetailedStudentResponseDTOImpl(findStudentByIdUseCase.execute(id));
        return ApiResponse.success("Student retrieved successfully", response);
    }
} 