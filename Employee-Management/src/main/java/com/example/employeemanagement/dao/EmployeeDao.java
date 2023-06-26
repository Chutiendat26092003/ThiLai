package com.example.employeemanagement.dao;

import com.example.employeemanagement.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static String URL = "jdbc:mysql://localhost:3306/egift_shop";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static Connection CONNECTION = getCONNECTION();

    private static Connection getCONNECTION() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public EmployeeDao() {
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            ResultSet rs = CONNECTION.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String birthDay = rs.getString("birthDay");
                String position = rs.getString("position");
                String department = rs.getString("department");

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setAddress(address);
                employee.setBirthDay(birthDay);
                employee.setPosition(position);
                employee.setDepartment(department);

                employees.add(employee);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return employees;
    }

    public Employee findById(int idEmp) {
        Employee employee = new Employee();

        try {
            ResultSet rs = CONNECTION.createStatement().executeQuery("SELECT * FROM employee WHERE id=" + idEmp);
            if(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String birthDay = rs.getString("birthDay");
                String position = rs.getString("position");
                String department = rs.getString("department");

                employee.setId(id);
                employee.setName(name);
                employee.setAddress(address);
                employee.setBirthDay(birthDay);
                employee.setPosition(position);
                employee.setDepartment(department);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return employee;
    }

    public void addEmp(Employee employee) {

        try {
            PreparedStatement pstmt = CONNECTION.prepareStatement("INSERT INTO employee (name, address, birthDay, position, department) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getAddress());
            pstmt.setString(3, employee.getBirthDay());
            pstmt.setString(4, employee.getPosition());
            pstmt.setString(5, employee.getDepartment());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(employee);
        }
    }

    public void update(Employee employee) {
        try {
            PreparedStatement pstmt = CONNECTION.prepareStatement("UPDATE employee set name=? , address=?, birthDay=?, position=?, department=? WHERE id=?");
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getAddress());
            pstmt.setString(3, employee.getBirthDay());
            pstmt.setString(4, employee.getPosition());
            pstmt.setString(5, employee.getDepartment());
            pstmt.setInt(6, employee.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int Id) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("DELETE FROM employee WHERE id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
