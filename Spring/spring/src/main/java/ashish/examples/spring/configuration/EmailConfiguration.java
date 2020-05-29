package ashish.examples.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ashish.examples.spring.serviceImpl.EmailService;
import ashish.examples.spring.services.MessageService;

@Configuration
@ComponentScan(value="ashish.examples.spring.Injector")
public class EmailConfiguration {
	
	@Bean
	public MessageService setMessageService() {
		return new EmailService();
	}
}

