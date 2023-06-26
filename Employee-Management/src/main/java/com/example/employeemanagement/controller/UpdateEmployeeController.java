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


@WebServlet(name = "editEmployeeServlet", value = "/edit")
public class UpdateEmployeeController extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Employee employee = ;
        //request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-employee.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birthDay = request.getParameter("birthDay");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        Employee newEmployee = new Employee(name, address, birthDay, position,department);
        employeeDao.update(newEmployee);
        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
