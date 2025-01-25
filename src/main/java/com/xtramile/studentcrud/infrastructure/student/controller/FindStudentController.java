package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.usecase.student.FindAllStudentUseCase;
import com.xtramile.studentcrud.usecase.student.dto.PaginatedStudentResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindStudentController {
    private final FindAllStudentUseCase findAllStudentUseCase;

    public FindStudentController(FindAllStudentUseCase findAllStudentUseCase) {
        this.findAllStudentUseCase = findAllStudentUseCase;
    }

    @GetMapping("/students")
    public PaginatedStudentResponseDTO findStudent(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return (PaginatedStudentResponseDTO) findAllStudentUseCase.execute(page, size);
    }
}
