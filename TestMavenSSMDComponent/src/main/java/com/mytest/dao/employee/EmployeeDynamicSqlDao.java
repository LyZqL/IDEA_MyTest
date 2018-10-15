package com.mytest.dao.employee;

import com.mytest.pojo.employee.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liu-zl
 * @Created on 2018/10/15.
 */
@Repository
public interface EmployeeDynamicSqlDao {

    //携带了哪个字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    //查询员工ids在给定集合中的
    public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    //批量保存
    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
