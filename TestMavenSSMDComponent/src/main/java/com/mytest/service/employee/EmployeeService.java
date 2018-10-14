package com.mytest.service.employee;

import com.mytest.pojo.employee.Employee;

import java.util.List;


public interface EmployeeService {

    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
