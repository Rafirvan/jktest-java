<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="com.rafirvan.jktestjava.model.Student" %>
<%@ page import="com.rafirvan.jktestjava.model.DepartmentStats" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="styles/welcome.css">
    <script>
        function showStudentName() {
            alert("Irvan");
        }
    </script>
</head>
<body>

<h1>Welcome <span onclick="showStudentName()" style="cursor: pointer; color: #007BFF; text-decoration: underline;"><%= request.getAttribute("userID") %></span></h1>

<table>
    <thead>
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass %</th>
    </tr>
    </thead>
    <tbody>

    <%
        Map<String, DepartmentStats> departmentStatsMap =
                (Map<String, DepartmentStats>) request.getAttribute("departmentStats");
        Map<String, DepartmentStats> sortedStatsMap = departmentStatsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, DepartmentStats> entry : sortedStatsMap.entrySet()) {
            DepartmentStats stats = entry.getValue();
            List<Student> studentsInDept = stats.getStudents();
            int passingCount = 0;

            for (Student student : studentsInDept) {
                if (student.getMarks() >= 40) passingCount++;
            }

            double passPercentage = studentsInDept.size() > 0 ? passingCount * 100.0 / studentsInDept.size() : 0;

            int rowspan = studentsInDept.size();
    %>

    <%
        for (int i = 0; i < studentsInDept.size(); i++) {
            Student student = studentsInDept.get(i);
    %>
    <tr>
        <% if (i == 0) { %>
        <td rowspan="<%= rowspan %>"><%= stats.getDepartmentName() %></td>
        <% } %>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getMarks() %></td>
        <% if (i == 0) { %>
        <td rowspan="<%= rowspan %>"><%= String.format("%.2f", passPercentage) + "%" %></td>
        <% } %>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>

</body>
</html>
