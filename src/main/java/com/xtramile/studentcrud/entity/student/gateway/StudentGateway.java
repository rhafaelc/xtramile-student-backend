package com.xtramile.studentcrud.entity.student.gateway;

import com.xtramile.studentcrud.entity.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentGateway {
    Student create(Student student);
    Student update(Student student);
    void delete(Long id);
    Optional<Student> findById(Long id);
    List<Student> find(int page, int size);
}
