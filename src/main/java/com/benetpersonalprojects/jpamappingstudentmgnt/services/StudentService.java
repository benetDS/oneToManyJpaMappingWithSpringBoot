package com.benetpersonalprojects.jpamappingstudentmgnt.services;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Student;
import com.benetpersonalprojects.jpamappingstudentmgnt.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(int theId) {
        return studentRepository.findById(theId);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(int theId) {
        studentRepository.deleteById(theId);
    }
}
