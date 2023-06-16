package com.benetpersonalprojects.jpamappingstudentmgnt.repositories;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolment;
import com.benetpersonalprojects.jpamappingstudentmgnt.entities.ClassEnrolmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassEnrolmentRepository extends JpaRepository<ClassEnrolment, ClassEnrolmentKey> {
}
