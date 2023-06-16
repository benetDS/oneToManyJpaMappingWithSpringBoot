package com.benetpersonalprojects.jpamappingstudentmgnt.controllers;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Class;
import com.benetpersonalprojects.jpamappingstudentmgnt.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{classId}")
    public ResponseEntity<?> getClassById(@PathVariable int classId) {
        Optional<Class> theClass = classService.getClassById(classId);
        if (theClass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot find class with ID - " + classId);
        } else {
            return ResponseEntity.ok(theClass.get());
        }
    }

    @PostMapping
    public Class addClass(@RequestBody Class classObj) {
        return classService.addClass(classObj);
    }

    @PutMapping
    public Class editClass(@RequestBody Class classObj) {
        return classService.updateClass(classObj);
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<String> deleteClassById(@PathVariable int classId) {
        Optional<Class> theClass = classService.getClassById(classId);
        if (theClass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cannot find class with ID - " + classId);
        } else {
            classService.deleteClassById(classId);
            return ResponseEntity.ok()
                    .body("Deleted class with ID - " + classId);
        }
    }
}
