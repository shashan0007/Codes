package ashish.examples.spring.springAOP.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeServiceExceptionAspect {
	
	@AfterThrowing("within(ashish.examples.spring.springAOP.aspect.EmployeeServiceExceptionAspect)")
	public void afterEmployeeServiceException() {
		System.out.println("Exception Message: ");
	}

}
