package ashish.examples.spring.springAOP.main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

@Aspect
@Component
public class Profiler {
	
	@Around("execution (* ashish.examples.spring.springAOP.model.*.*(..)) || execution(* ashish.examples.spring.springAOP.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Running profiler for " + pjp.getSignature().getName());
		StopWatch watch = new StopWatch();
		boolean isExceptionThrown = false;
		String outFormat = "Task Name - %s : TaskTime - %s : Exception : %s";
		watch.start(pjp.toShortString());
		
		try {
			return pjp.proceed();
		}catch(Exception e) {
			isExceptionThrown = true;
			throw e;
		}
		finally {
			watch.stop();
			TaskInfo task = watch.getLastTaskInfo();
			String taskName = task.getTaskName();
			long taskTime = task.getTimeMillis();
			System.out.println(String.format(outFormat, taskName,taskTime,isExceptionThrown));
		}	
	}
}
