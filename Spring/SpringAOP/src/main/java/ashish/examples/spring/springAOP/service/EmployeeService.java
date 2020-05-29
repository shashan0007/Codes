package ashish.examples.spring.springAOP.service;

import ashish.examples.spring.springAOP.model.Employee;

public class EmployeeService {

	private Employee employee;
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee e){
		this.employee=e;
	}
	
	public void throwException() {
		throw new RuntimeException("Exception thrown from Employee Service");
	}
	
}
