package com.db_conn_course.model;

import java.util.Date;

public class EmployeeBuilder {
    private String name;
    private int id;
    private double salary;
    private boolean gender;
    private Date birth_date;


    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }


    public EmployeeBuilder id(int id) {
        this.id = id;
        return this;
    }


    public EmployeeBuilder salary(double salary) {
        this.salary = salary;
        return this;
    }


    public EmployeeBuilder gender(boolean gender) {
        this.gender = gender;
        return this;
    }


    public EmployeeBuilder data(Date date){
        this.birth_date=date;
        return this;
    }

    public Employee build(){
        return new Employee(name,id,salary,gender,birth_date);
    }
}
