package com.springbootschoolv2.springbootschoolv2.repository;

import com.springbootschoolv2.springbootschoolv2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
