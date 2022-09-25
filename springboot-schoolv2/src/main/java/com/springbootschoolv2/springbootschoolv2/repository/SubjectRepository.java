package com.springbootschoolv2.springbootschoolv2.repository;

import com.springbootschoolv2.springbootschoolv2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
