package com.xtramile.studentcrud.infrastructure.student.gateway;

import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.entity.student.model.Student;
import com.xtramile.studentcrud.infrastructure.db.repository.StudentRepository;
import com.xtramile.studentcrud.infrastructure.db.schema.StudentSchema;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentGatewayImpl implements StudentGateway {
    private final StudentRepository studentRepository;

    public StudentGatewayImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(new StudentSchema(student)).toStudent();
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(new StudentSchema(student)).toStudent();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id).map(StudentSchema::toStudent);
    }

    @Override
    public List<Student> find(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
        return studentRepository.findAll(pageRequest)
                .getContent()
                .stream()
                .map(StudentSchema::toStudent)
                .toList();
    }

    @Override
    public long count() {
        return studentRepository.count();
    }
}
