package com.benetpersonalprojects.jpamappingstudentmgnt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "class_enrolment")
public class ClassEnrolment {
    @EmbeddedId
    private ClassEnrolmentKey classEnrolmentKey;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    private Class classObj;

    @Column(name = "admission_staff_name")
    private String admissionStaffName;

    public ClassEnrolment() {
    }

    public ClassEnrolment(
            ClassEnrolmentKey classEnrolmentKey,
            Student student,
            Class classObj,
            String admissionStaffName) {
        this.classEnrolmentKey = classEnrolmentKey;
        this.student = student;
        this.classObj = classObj;
        this.admissionStaffName = admissionStaffName;
    }

    public ClassEnrolmentKey getClassEnrolmentKey() {
        return classEnrolmentKey;
    }

    public void setClassEnrolmentKey(ClassEnrolmentKey classEnrolmentKey) {
        this.classEnrolmentKey = classEnrolmentKey;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClassObj() {
        return classObj;
    }

    public void setClassObj(Class classObj) {
        this.classObj = classObj;
    }

    public String getAdmissionStaffName() {
        return admissionStaffName;
    }

    public void setAdmissionStaffName(String admissionStaffName) {
        this.admissionStaffName = admissionStaffName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassEnrolment that)) return false;
        return Objects.equals(getClassEnrolmentKey(), that.getClassEnrolmentKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassEnrolmentKey());
    }
}
