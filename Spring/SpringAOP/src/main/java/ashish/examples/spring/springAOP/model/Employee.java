package ashish.examples.spring.springAOP.model;

import ashish.examples.spring.springAOP.annotation.Loggable;

public class Employee {
	
	private String name;

	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String name) {
		this.name = name;
	}
}
