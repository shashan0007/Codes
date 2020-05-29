package ashish.examples.spring.springAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import ashish.examples.spring.springAOP.annotation.Loggable;

@Aspect
public class EmployeeAroundAspect {

	@Loggable
	@Around("execution(* ashish.examples.spring.springAOP.model.Employee.set*(*))")
	public void aroundSettingEmployeeName(ProceedingJoinPoint joint) {
		System.out.println("Around calling method : " + joint.getSignature().toString());
		try {
			joint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
