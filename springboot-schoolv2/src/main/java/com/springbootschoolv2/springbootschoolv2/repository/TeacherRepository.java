package com.springbootschoolv2.springbootschoolv2.repository;

import com.springbootschoolv2.springbootschoolv2.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
