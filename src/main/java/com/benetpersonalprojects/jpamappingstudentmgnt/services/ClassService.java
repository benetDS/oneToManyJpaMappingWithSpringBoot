package com.benetpersonalprojects.jpamappingstudentmgnt.services;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Class;
import com.benetpersonalprojects.jpamappingstudentmgnt.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<Class> getClassById(int theId) {
        return classRepository.findById(theId);
    }

    public Class addClass(Class classObj) {
        return classRepository.save(classObj);
    }

    public Class updateClass(Class classObj) {
        return classRepository.save(classObj);
    }

    public void deleteClassById(int theId) {
        classRepository.deleteById(theId);
    }
}
