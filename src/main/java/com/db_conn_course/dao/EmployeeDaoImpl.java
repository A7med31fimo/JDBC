package com.db_conn_course.dao;

import com.db_conn_course.Utiles.utile;
import com.db_conn_course.model.Employee;
import com.db_conn_course.model.EmployeeBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        Connection connection = DBconnection.getConnection();
        String query = "SELECT * FROM employee";
        List<Employee> employees = new LinkedList<Employee>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                Employee employee = new Employee(
//                        resultSet.getString("name"),
//                        resultSet.getInt("id"),
//                        resultSet.getDouble("salary"),
//                        resultSet.getBoolean("gender"),
//                        resultSet.getDate(("birth_date")));

                Employee employee = Employee.builder().id(resultSet.getInt("id")).data(resultSet.getDate(("birth_date")))
                        .name(resultSet.getString("name")).salary(resultSet.getDouble("salary"))
                        .gender(resultSet.getBoolean("gender")).build();
                employees.add(employee);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    @Override
    public Employee find_By_id(int id) {
        Connection connection = DBconnection.getConnection();
        String query = "SELECT * FROM employee WHERE id = ?";

        Employee employee = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getDouble("salary"),
                        resultSet.getBoolean("gender"),
                        resultSet.getDate(("birth_date")));
            } else {
                return null;
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {

        Connection connection = DBconnection.getConnection();
        if (connection == null) {
            return;
        }

        if (employee.getId() > 0) {//Update
            String query = "UPDATE employee set name=?,gender=?,salary=?,birth_date=? WHERE id=?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDouble(3, employee.getSalary());
                preparedStatement.setDate(4, utile.getSQLDate(employee.getDate()));
                preparedStatement.setInt(5, employee.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException sq) {
                sq.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else { //insert
            String query = "INSERT INTO employee (name,gender,salary,birth_date) VALUES(?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDouble(3, employee.getSalary());
                preparedStatement.setDate(4, utile.getSQLDate(employee.getDate()));

                preparedStatement.executeUpdate();

            } catch (SQLException sq) {
                sq.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void delete_by_id(int id) {
        Connection connection = DBconnection.getConnection();

        if (connection == null) {
            return;
        }
        String query = "DELETE FROM employee where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
