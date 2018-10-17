import com.mytest.pojo.employee.Employee;
import com.mytest.service.employee.EmployeeService;
import com.mytest.service.employee.impl.EmployeeServiceImpl;
import com.mytest.utils.BeanFactory;

import java.util.Map;

public class MyTest {

    private static EmployeeService employeeService = BeanFactory.getBean(EmployeeServiceImpl.class);


    public static void main(String[] args) {

        Map<Integer, Employee> emp = employeeService.getEmpByLastNameLikeReturnMap("海商法");
        System.out.println(emp.get(1));
    }
}
