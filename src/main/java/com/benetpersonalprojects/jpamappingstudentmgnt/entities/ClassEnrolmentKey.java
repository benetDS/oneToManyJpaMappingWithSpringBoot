package com.benetpersonalprojects.jpamappingstudentmgnt.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassEnrolmentKey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "class_id")
    private int classId;

    public ClassEnrolmentKey() {}

    public ClassEnrolmentKey(int studentId, int classId) {
        this.studentId = studentId;
        this.classId = classId;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassEnrolmentKey that)) return false;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId);
    }
}
