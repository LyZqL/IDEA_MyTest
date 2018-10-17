package com.mytest.service.employee;

import com.mytest.pojo.employee.Employee;

import java.util.List;
import java.util.Map;


public interface EmployeeService {

    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public Employee getEmpByMap(Map<String, Object> map);

    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    public Employee getEmpByLastname(String lastName);

    public Employee getEmpAndDept(Integer id);
}
