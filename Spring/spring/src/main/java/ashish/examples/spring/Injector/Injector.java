package ashish.examples.spring.Injector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ashish.examples.spring.services.MessageService;

@Component
public class Injector {
	
	private MessageService service;

	@Autowired
	public void setService(MessageService service) {
		this.service = service;
	}

	public void processMessage() {
		service.sendMessage();
	}

}
