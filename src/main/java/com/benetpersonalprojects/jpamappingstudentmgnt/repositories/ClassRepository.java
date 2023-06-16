package com.benetpersonalprojects.jpamappingstudentmgnt.repositories;

import com.benetpersonalprojects.jpamappingstudentmgnt.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
}
