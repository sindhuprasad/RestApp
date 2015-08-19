package com.rest.employee;

import com.rest.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Sindhu on 8/13/15.
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee save(Employee employee){
        Employee newEmployee = null;
        try {
            newEmployee = dao.createEmployee(employee);
        }catch (Exception e){
            System.out.println("Inside employeedao save method "+e);
        }
        return newEmployee;
    }

    public Employee get(int employeeID){
        Employee employee = null;
        try{
            employee = dao.getEmployee(employeeID);
        }catch (Exception e){
            System.out.println("Inside employeedao get method "+e);
        }
        return employee;
    }
}
