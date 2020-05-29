package ashish.examples.spring.springAOP.aspect;

import org.aspectj.lang.JoinPoint;

public class EmployeeAfterAspect {
	
	public void afterSettingEmployeeName(JoinPoint joint) {
		System.out.println("Set name for employee : " + joint.getArgs());
	}
}
