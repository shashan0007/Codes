package ashish.examples.spring.Consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ashish.examples.spring.Injector.Injector;
import ashish.examples.spring.configuration.SMSConfiguration;

public class Application1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SMSConfiguration.class);
		Injector inject = context.getBean(Injector.class);

		inject.processMessage();
		
		context.close();
	}

}
