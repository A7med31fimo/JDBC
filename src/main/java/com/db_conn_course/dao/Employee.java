package com.db_conn_course.dao;

import java.util.Date;

public class Employee {
    private String name;
    private int id;
    private double salary;
    private boolean gender;
    private Date birth_date;

    public Employee() {
    }

    public Employee(String name, int id, double salary, boolean gender, Date date) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.gender = gender;
        this.birth_date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return birth_date;
    }

    public void setDate(Date date) {
        this.birth_date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", gender=" + gender +
                ", date=" + birth_date +
                '}';
    }
}
