package com.mytest.service.employee.impl;

import com.mytest.dao.employee.EmployeeDao;
import com.mytest.pojo.employee.Employee;
import com.mytest.service.employee.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /*用来进行批量操作*/
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Employee getEmpById(Integer id) {
        return employeeDao.getEmpById(id);
    }

    @Override
    public List<Employee> getEmps() {
        System.out.println("getEmps()........");
        //获取接口实现类对象
        //EmployeeMapper mapper = sqlSession.getMapper(EmployeeDao.class);
        //        for (int i = 0; i < 10000; i++) {
        //            mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0, 5), "b", "1"));
        //        }
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

    @Override
    public Employee getEmpByMap(Map<String, Object> map) {
        return employeeDao.getEmpByMap(map);
    }

    @Override
    public Map<String, Object> getEmpByIdReturnMap(Integer id) {
        return employeeDao.getEmpByIdReturnMap(id);
    }

    @Override
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName) {
        return employeeDao.getEmpByLastNameLikeReturnMap(lastName);
    }

    @Override
    public Employee getEmpByLastname(String lastName) {
        return employeeDao.getEmpByLastname(lastName);
    }

    @Override
    public Employee getEmpAndDept(Integer id) {
        return employeeDao.getEmpAndDept(id);
    }


}
