package com.mytest.dao.department;


import com.mytest.pojo.department.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao {

    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);
}
