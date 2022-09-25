package com.springbootschoolv2.springbootschoolv2.controller;

import com.springbootschoolv2.springbootschoolv2.entity.Student;
import com.springbootschoolv2.springbootschoolv2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    Student getStudentById(@RequestBody Student student, @PathVariable(value = "id") Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        Student existingStudent = studentRepository.findById(studentId).get();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return studentRepository.save(existingStudent);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Student> deleteStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        Student existingStudent = studentRepository.findById(studentId).get();
        studentRepository.delete(existingStudent);
        return ResponseEntity.ok().build();
    }
}
