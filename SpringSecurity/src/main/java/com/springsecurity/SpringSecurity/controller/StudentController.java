package com.springsecurity.SpringSecurity.controller;

import com.springsecurity.SpringSecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(
            List.of(new Student(1,"Het",99),
                    new Student(2,"Mitali",99))
    );

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getALlStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
