package com.jmy.dto;

import com.jmy.pojo.admin.Major;
import com.jmy.pojo.admin.Subject;

public class MajorSubject {

    private Major major;

    private Subject subject;


    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MajorSubject{" +
                "major=" + major +
                ", subject=" + subject +
                '}';
    }
}
