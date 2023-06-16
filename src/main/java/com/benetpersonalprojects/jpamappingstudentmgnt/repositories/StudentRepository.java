package com.benetpersonalprojects.jpamappingstudentmgnt.repositories;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
