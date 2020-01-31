import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.service.EmployeeService;

public class Application {
	
	public static void main(String [] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		EmployeeService employeeService = applicationContext.getBean("employeeService",EmployeeService.class);
		System.out.println(employeeService);
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+" at "+employee.getEmployeeLocation());
		}
		
		EmployeeService employeeService2 = applicationContext.getBean("employeeService",EmployeeService.class);
		System.out.println(employeeService2);
		List<Employee> employees2 = employeeService.getAllEmployees();
		
		for(Employee employee : employees2) {
			System.out.println(employee.getEmployeeName()+" at "+employee.getEmployeeLocation());
		}
		
	}

}
