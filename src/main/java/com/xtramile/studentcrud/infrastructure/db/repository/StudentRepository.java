package com.xtramile.studentcrud.infrastructure.db.repository;

import com.xtramile.studentcrud.infrastructure.db.schema.StudentSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentSchema, Long> {
}
