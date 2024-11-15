package com.rafirvan.jktestjava.model;

public class Student {
    private String studentId;
    private String department;
    private int marks;

    public Student(String studentId, String department, int marks) {
        this.studentId = studentId;
        this.department = department;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public int getMarks() {
        return marks;
    }

    public boolean isPassed() {
        return marks >= 40;
    }
}