package com.xtramile.studentcrud.infrastructure.config;

import com.xtramile.studentcrud.entity.student.gateway.StudentGateway;
import com.xtramile.studentcrud.infrastructure.db.repository.StudentRepository;
import com.xtramile.studentcrud.infrastructure.student.gateway.StudentGatewayImpl;
import com.xtramile.studentcrud.usecase.student.CreateStudentUseCase;
import com.xtramile.studentcrud.usecase.student.DeleteStudentUseCase;
import com.xtramile.studentcrud.usecase.student.FindAllStudentUseCase;
import com.xtramile.studentcrud.usecase.student.UpdateStudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepository studentRepository) {
        StudentGateway studentGateway = new StudentGatewayImpl(studentRepository);
        return new CreateStudentUseCase(studentGateway);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(StudentRepository studentRepository) {
        StudentGateway studentGateway = new StudentGatewayImpl(studentRepository);
        return new UpdateStudentUseCase(studentGateway);
    }

    @Bean
    public DeleteStudentUseCase deleteStudentUseCase(StudentRepository studentRepository) {
        StudentGateway studentGateway = new StudentGatewayImpl(studentRepository);
        return new DeleteStudentUseCase(studentGateway);
    }

    @Bean
    public FindAllStudentUseCase findAllStudentUseCase(StudentRepository studentRepository) {
        StudentGateway studentGateway = new StudentGatewayImpl(studentRepository);
        return new FindAllStudentUseCase(studentGateway);
    }
}
