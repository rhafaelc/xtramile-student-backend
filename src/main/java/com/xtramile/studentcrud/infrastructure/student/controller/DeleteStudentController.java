package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.infrastructure.common.ApiResponse;
import com.xtramile.studentcrud.usecase.student.DeleteStudentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class DeleteStudentController {

    private final DeleteStudentUseCase deleteStudentUseCase;

    public DeleteStudentController(DeleteStudentUseCase deleteStudentUseCase) {
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        deleteStudentUseCase.execute(id);
        return ApiResponse.success("Student successfully deleted");
    }
}
