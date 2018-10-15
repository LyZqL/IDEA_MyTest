package com.mytest.test;


import com.mytest.generator.bean.Employee;
import com.mytest.generator.bean.EmployeeExample;
import com.mytest.generator.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testMyBatis() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //xxxExample就是封装查询条件的
            //1、查询所有
            //List<Employee> emps = mapper.selectByExample(null);
            //2、查询员工名字中有e字母的，和员工性别是1的
            //封装员工查询条件的example
            EmployeeExample example = new EmployeeExample();
            //创建一个Criteria，这个Criteria就是拼装查询条件
            //select id, last_name, email, gender, d_id from tbl_employee
            //WHERE ( last_name like ? and gender = ? ) or email like "%e%"
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%e%");
            criteria.andGenderEqualTo("1");

            //新创建一个criteria进行or操作
            EmployeeExample.Criteria criteria2 = example.createCriteria();
            criteria2.andEmailLike("%e%");
            example.or(criteria2);

            List<Employee> list = mapper.selectByExample(example);
            for (Employee employee : list) {
                System.out.println(employee.getId());
            }

        } finally {
            openSession.close();
        }
    }
}
