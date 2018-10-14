import com.mytest.dao.employee.EmployeeDao;
import com.mytest.pojo.employee.Employee;
import com.mytest.service.employee.EmployeeService;
import com.mytest.service.employee.impl.EmployeeServiceImpl;
import com.mytest.utils.BeanFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author liu-zl
 * @Created on 2018/10/13.
 */
public class MyTest {

    private static EmployeeService employeeService = BeanFactory.getBean(EmployeeServiceImpl.class);


    public static void main(String[] args) {

        List<Employee> emps = employeeService.getEmps();
        System.out.println(emps);
    }
}
