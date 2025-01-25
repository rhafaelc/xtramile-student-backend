package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.infrastructure.student.dto.StudentResponseDTOImpl;
import com.xtramile.studentcrud.infrastructure.student.dto.UpdateStudentDTOImpl;
import com.xtramile.studentcrud.usecase.student.UpdateStudentUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UpdateStudentController {
    private final UpdateStudentUseCase updateStudentUseCase;

    public UpdateStudentController(UpdateStudentUseCase updateStudentUseCase) {
        this.updateStudentUseCase = updateStudentUseCase;
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<StudentResponseDTOImpl> updateStudent(@PathVariable Long id, @Valid @RequestBody UpdateStudentDTOImpl dto) throws StudentNotFoundException {
        StudentResponseDTOImpl response = new StudentResponseDTOImpl(updateStudentUseCase.execute(id, dto));
        return ApiResponse.success("Student successfully updated", response);
    }
}
