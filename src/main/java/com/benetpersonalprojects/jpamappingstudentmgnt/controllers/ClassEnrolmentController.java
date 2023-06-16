package com.benetpersonalprojects.jpamappingstudentmgnt.controllers;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolment;
import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolmentKey;
import com.benetpersonalprojects.jpamappingstudentmgnt.services.ClassEnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrolments")
public class ClassEnrolmentController {
    @Autowired
    private ClassEnrolmentService classEnrolmentService;

    @GetMapping
    public List<ClassEnrolment> getAllEnrolments() {
        return classEnrolmentService.getAllClassEnrolments();
    }

    @GetMapping("/{studentId}-{classId}")
    public ResponseEntity<?> getEnrolmentById(@PathVariable int studentId, @PathVariable int classId) {
        Optional<ClassEnrolment> enrolment = classEnrolmentService.getClassEnrolmentById(
                new ClassEnrolmentKey(studentId, classId));
        if (enrolment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot retrieve student with ID - " + studentId +
                            " enrolled class with ID - " + classId);
        } else {
            return ResponseEntity.ok(enrolment.get());
        }
    }

    @PostMapping
    public Object addEnrolment(@RequestBody ClassEnrolment enrolment) {
        if (enrolment.getClassEnrolmentKey().getStudentId() == enrolment.getStudent().getStudentId() &&
                enrolment.getClassEnrolmentKey().getClassId() == enrolment.getClassObj().getClassId()) {
            return classEnrolmentService.addClassEnrolment(enrolment);
        } else {
            return "Request cannot be executed: Unmatched student or class ID";
        }
    }

    @PutMapping
    public Object editEnrolment(@RequestBody ClassEnrolment enrolment) {
        if (enrolment.getClassEnrolmentKey().getStudentId() == enrolment.getStudent().getStudentId() &&
                enrolment.getClassEnrolmentKey().getClassId() == enrolment.getClassObj().getClassId()) {
            return classEnrolmentService.addClassEnrolment(enrolment);
        } else {
            return "Request cannot be executed: Unmatched student or class ID";
        }
    }

    @DeleteMapping("/{studentId}-{classId}")
    public ResponseEntity<String> deleteEnrolmentById(@PathVariable int studentId, @PathVariable int classId) {
        ClassEnrolmentKey key = new ClassEnrolmentKey(studentId, classId);
        Optional<ClassEnrolment> enrolment = classEnrolmentService.getClassEnrolmentById(key);
        if (enrolment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot retrieve student with ID - " + studentId +
                            " enrolled class with ID - " + classId);
        } else {
            classEnrolmentService.deleteClassEnrolmentById(key);
            return ResponseEntity.ok()
                    .body("Deleted enrolment history: student ID - " + studentId +
                            ", class ID - " + classId);
        }
    }
}
