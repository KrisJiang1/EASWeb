package com.jmy.dto;

import com.jmy.pojo.admin.Student;
import com.jmy.pojo.admin.Subject;

public class StudentSubject {

    private Student student;

    private Subject subject;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "student=" + student +
                ", subject=" + subject +
                '}';
    }
}
