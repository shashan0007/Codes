package ashish.examples.spring.springAOP.aspect;

import org.aspectj.lang.JoinPoint;

public class EmployeeBeforeAspect {

	public void beforeSettingEmployeeName(JoinPoint joint) {
		System.out.println("Going to get name for method : " + joint.getSignature().toString());
	}
}
