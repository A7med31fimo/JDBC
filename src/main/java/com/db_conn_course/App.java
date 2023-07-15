package com.db_conn_course;


import com.db_conn_course.dao.Employee;
import com.db_conn_course.dao.EmployeeDao;
import com.db_conn_course.dao.EmployeeDaoImpl;

import java.util.Date;

public class App {
    public static void main(String[] args) {
//      Employee employee=new Employee("alaa fahim", 1, 3000.0, true, new Date());
        EmployeeDao emp=new EmployeeDaoImpl();
//      emp.save(employee);
//      emp.findAll().forEach(System.out::println);
        Employee employee=emp.find_By_id(1);

        System.out.println(employee.toString());
        System.out.println("DONE !");

    }
}
