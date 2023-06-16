package com.benetpersonalprojects.jpamappingstudentmgnt.services;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolment;
import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolmentKey;
import com.benetpersonalprojects.jpamappingstudentmgnt.repositories.ClassEnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassEnrolmentService {
    @Autowired
    private ClassEnrolmentRepository classEnrolmentRepository;

    @Autowired
    public ClassEnrolmentService(ClassEnrolmentRepository classEnrolmentRepository) {
        this.classEnrolmentRepository = classEnrolmentRepository;
    }

    public List<ClassEnrolment> getAllClassEnrolments() {
        return classEnrolmentRepository.findAll();
    }

    public Optional<ClassEnrolment> getClassEnrolmentById(ClassEnrolmentKey key) {
        return classEnrolmentRepository.findById(key);
    }

    public ClassEnrolment addClassEnrolment(ClassEnrolment enrolment) {
        return classEnrolmentRepository.save(enrolment);
    }

    public ClassEnrolment updateClassEnrolment(ClassEnrolment enrolment) {
        return classEnrolmentRepository.save(enrolment);
    }

    public void deleteClassEnrolmentById(ClassEnrolmentKey key) {
        classEnrolmentRepository.deleteById(key);
    }
}
