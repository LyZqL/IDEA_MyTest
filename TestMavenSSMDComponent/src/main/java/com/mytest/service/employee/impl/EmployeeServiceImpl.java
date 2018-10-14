package com.mytest.service.employee.impl;

import com.mytest.dao.employee.EmployeeDao;
import com.mytest.pojo.employee.Employee;
import com.mytest.service.employee.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Employee getEmpById(Integer id) {
        return employeeDao.getEmpById(id);
    }

    @Override
    public List<Employee> getEmps() {
        System.out.println("getEmps()........");
        //
        //EmployeeMapper mapper = sqlSession.getMapper(EmployeeDao.class);
        return employeeDao.getEmps();
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmpById(Integer id) {
        employeeDao.deleteEmpById(id);
    }

}
