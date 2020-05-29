package ashish.examples.spring.springAOP.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ashish.examples.spring.springAOP.service.EmployeeService;

@Configuration
//@ComponentScan(basePackages="ashish.examples.spring.springAOP.*")
public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-aop.xml");
		
		EmployeeService service = context.getBean("EmployeeService", EmployeeService.class);
		String name = service.getEmployee().getName();
		System.out.println("Name of Employee in bean configuration: " + name);
		service.getEmployee().setName("Ashish");
		service.getEmployee().getName();
		service.throwException();
		context.close();
	}

}
