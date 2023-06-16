package com.benetpersonalprojects.jpamappingstudentmgnt.controllers;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Student;
import com.benetpersonalprojects.jpamappingstudentmgnt.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable int studentId) {
        Optional<Student> theStudent = studentService.findById(studentId);
        if (theStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot find the student with ID - " + studentId);
        } else {
            return ResponseEntity.ok(theStudent.get());
        }
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int studentId) {
        Optional<Student> theStudent = studentService.findById(studentId);
        if (theStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot find the student with ID - " + studentId);
        } else {
            studentService.deleteStudentById(studentId);
            return ResponseEntity.ok()
                    .body("Deleted student with ID - " + studentId);
        }
    }
}
