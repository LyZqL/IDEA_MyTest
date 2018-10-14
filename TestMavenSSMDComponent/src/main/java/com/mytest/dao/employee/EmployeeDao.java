package com.mytest.dao.employee;


import com.mytest.pojo.employee.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {


    /**
     * 测试增删改
     * 1、mybatis允许增删改直接定义以下类型返回值,xml文件中无需指定
     * 		Integer、Long、Boolean、void
     * 2、我们需要手动提交数据
     * 		sqlSessionFactory.openSession();===》手动提交
     * 		sqlSessionFactory.openSession(true);===》自动提交
     */
    // 基于注解的方式@Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public Long addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

}
