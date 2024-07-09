package com.bluu.demo.rest;

import com.bluu.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("James", "Bond"));
        theStudents.add(new Student("Mary", "Smith"));

        return theStudents;
    }
}
