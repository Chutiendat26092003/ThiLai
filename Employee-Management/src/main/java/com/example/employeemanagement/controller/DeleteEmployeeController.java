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

@WebServlet(name = "deleteEmployeeServlet", value = "/delete")
public class DeleteEmployeeController extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        employeeDao.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
