package com.example.employeemanagement.controller;

import com.example.employeemanagement.dao.EmployeeDao;
import com.example.employeemanagement.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeListServlet", value = "/employees")
public class EmployeeListController extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employeeList = employeeDao.getAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-employees.jsp");
        dispatcher.forward(request, response);
    }
}
