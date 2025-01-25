package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.infrastructure.student.dto.CreateStudentDTOImpl;
import com.xtramile.studentcrud.infrastructure.student.dto.StudentResponseDTOImpl;
import com.xtramile.studentcrud.usecase.student.CreateStudentUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CreateStudentController {
    private final CreateStudentUseCase createStudentUseCase;

    public CreateStudentController(CreateStudentUseCase createStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<StudentResponseDTOImpl> createStudent(@Valid @RequestBody CreateStudentDTOImpl dto) {
        StudentResponseDTOImpl response = new StudentResponseDTOImpl(createStudentUseCase.execute(dto));
        return ApiResponse.created("Student successfully created", response);
    }
}
