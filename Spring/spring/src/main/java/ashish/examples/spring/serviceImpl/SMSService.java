package ashish.examples.spring.serviceImpl;

import ashish.examples.spring.services.MessageService;

public class SMSService implements MessageService {

	public void sendMessage() {
		System.out.println("SMS Sent");
	}

}
