package com.rafirvan.jktestjava.model;

import com.rafirvan.jktestjava.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DepartmentStats {
    private String departmentName;
    private List<Student> students;

    public DepartmentStats(String departmentName) {
        this.departmentName = departmentName;
        this.students = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Add a student to the department
    public void addStudent(Student student) {
        this.students.add(student);
    }
}
