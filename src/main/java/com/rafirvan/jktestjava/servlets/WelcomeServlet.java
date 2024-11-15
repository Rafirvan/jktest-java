package com.rafirvan.jktestjava.servlets;

import com.rafirvan.jktestjava.model.Student;
import com.rafirvan.jktestjava.model.DepartmentStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = createStudents();

        Map<String, DepartmentStats> departmentStatsMap = createDepartmentStatsMap(students);

        request.setAttribute("students", students);
        request.setAttribute("departmentStats", departmentStatsMap);

        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    private List<Student> createStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S1", "Dep 1", 85));
        students.add(new Student("S2", "Dep 1", 65));
        students.add(new Student("S3", "Dep 1", 40));
        students.add(new Student("S4", "Dep 1", 30));
        students.add(new Student("S5", "Dep 2", 32));
        students.add(new Student("S6", "Dep 2", 38));
        students.add(new Student("S7", "Dep 3", 88));
        students.add(new Student("S8", "Dep 3", 94));
        return students;
    }

    private Map<String, DepartmentStats> createDepartmentStatsMap(List<Student> students) {
        Map<String, DepartmentStats> departmentStatsMap = new HashMap<>();
        for (Student student : students) {
            String department = student.getDepartment();
            departmentStatsMap
                    .computeIfAbsent(department, DepartmentStats::new)
                    .addStudent(student);
        }
        return departmentStatsMap;
    }
}
