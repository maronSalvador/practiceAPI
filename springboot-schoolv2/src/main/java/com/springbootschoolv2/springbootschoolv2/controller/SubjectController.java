package com.springbootschoolv2.springbootschoolv2.controller;

import com.springbootschoolv2.springbootschoolv2.entity.Student;
import com.springbootschoolv2.springbootschoolv2.entity.Subject;
import com.springbootschoolv2.springbootschoolv2.entity.Teacher;
import com.springbootschoolv2.springbootschoolv2.repository.StudentRepository;
import com.springbootschoolv2.springbootschoolv2.repository.SubjectRepository;
import com.springbootschoolv2.springbootschoolv2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Subject> getSubject() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    Subject getSubjectById(@RequestBody Subject subject, @PathVariable(value = "id") Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrolledStudentsToSubjects(@PathVariable Long subjectId, @PathVariable Long studentId) {
        Subject subject = this.subjectRepository.findById(subjectId).get();
        Student student = this.studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return this.subjectRepository.save(subject);

    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        Subject subject = this.subjectRepository.findById(subjectId).get();
        Teacher teacher = this.teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return this.subjectRepository.save(subject);
    }


}