package com.example.employeemanagement.entity;

public class Employee {
    protected int id;
    protected String name;
    protected String address;
    protected String birthDay ;
    protected String position;
    protected String department;
    public Employee(){};

    public Employee(int id, String name, String address, String birthDay, String position, String department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, String address, String birthDay, String position, String department) {
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

