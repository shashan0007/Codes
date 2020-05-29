package ashish.examples.spring.serviceImpl;

import ashish.examples.spring.services.MessageService;

public class EmailService implements MessageService {

	public void sendMessage() {
		System.out.println("Email sent");
	}

}
