package com.xtramile.studentcrud.infrastructure.student.controller;

import com.xtramile.studentcrud.entity.student.exception.StudentNotFoundException;
import com.xtramile.studentcrud.usecase.student.DeleteStudentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {

    private final DeleteStudentUseCase deleteStudentUseCase;

    public DeleteStudentController(DeleteStudentUseCase deleteStudentUseCase) {
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        deleteStudentUseCase.execute(id);
    }
}
