package com.mytest.dao.employee;


import com.mytest.pojo.employee.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeDao {


    /**
     * 测试增删改
     * 1、mybatis允许增删改直接定义以下类型返回值,xml文件中无需指定
     * Integer、Long、Boolean、void
     * 2、我们需要手动提交数据
     * sqlSessionFactory.openSession();===》手动提交
     * sqlSessionFactory.openSession(true);===》自动提交
     */
    // 基于注解的方式@Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public Long addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public Employee getEmpByMap(Map<String, Object> map);

    //将一条记录封装为map；key就是列名(属性名)，值就是对应的值
    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("id")
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    public Employee getEmpByLastname(String lastName);

    public Employee getEmpAndDept(Integer id);
}
