package com.db_conn_course;


import com.db_conn_course.model.Employee;
import com.db_conn_course.dao.EmployeeDao;
import com.db_conn_course.dao.EmployeeDaoImpl;

import java.util.Date;

public class App {
    public static void main(String[] args) {
//      Employee employee=new Employee("ahmed fahim", 0, 3000.0, true, new Date());
      EmployeeDao emp=new EmployeeDaoImpl();
//      emp.save(employee);
//      emp.findAll().forEach(System.out::println);
//      Employee employee=emp.find_By_id(1);

//      System.out.println(employee.toString());
      emp.delete_by_id(1);
      System.out.println("DONE !");

    }
}
