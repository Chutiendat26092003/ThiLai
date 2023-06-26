<%--
  Created by IntelliJ IDEA.
  User: chu tien dat
  Date: 6/19/2023
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="org.employee.employeemanagement.dao.EmployeeDao" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>List Employees</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>BirthDay</th>
            <th>Position</th>
            <th>Department</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${employeeList}">
            <tr>
                <td name="id">${item.id}</td>
                <td>${item.name}</td>
                <td>${item.address}</td>
                <td>${item.birthDay}</td>
                <td>${item.position}</td>
                <td>${item.department}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${item.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete?id=${item.id}">Delete</a>
                    </ul>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/create" class="btn btn-success">Add Employee</a>
</div>
</body>
</html>
