package com.db_conn_course.dao;

import com.db_conn_course.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee find_By_id(int id);
    void save(Employee employee);
    void delete_by_id(int id);
}
