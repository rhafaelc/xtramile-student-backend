package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.infrastructure.student.dto.StudentResponseDTOImpl;
import com.xtramile.studentcrud.usecase.student.FindStudentByIdUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindStudentByIdController {
    private final FindStudentByIdUseCase findStudentByIdUseCase;

    public FindStudentByIdController(FindStudentByIdUseCase findStudentByIdUseCase) {
        this.findStudentByIdUseCase = findStudentByIdUseCase;
    }

    @GetMapping("/students/{id}")
    public ApiResponse<StudentResponseDTOImpl> findStudentById(@PathVariable Long id) {
        StudentResponseDTOImpl response = new StudentResponseDTOImpl(findStudentByIdUseCase.execute(id));
        return ApiResponse.success("Student retrieved successfully", response);
    }
} 