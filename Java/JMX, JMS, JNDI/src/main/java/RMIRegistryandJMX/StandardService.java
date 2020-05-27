package RMIRegistryandJMX;

import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;

public class StandardService extends NotificationBroadcasterSupport implements StandardServiceMBean {
	
	private String state;
	private int noOfChanges;

	public void setState(String state) {
		this.state = state;
		noOfChanges++;
	}

	public String getState() {
		return this.state;
	}

	public int getNoOfChanges() {
		return this.noOfChanges;
	}

	public void reset() {
		this.state = "Initial State";
		this.noOfChanges = 0;
		AttributeChangeNotification acn = new AttributeChangeNotification(this, 
				0, 
				0, 
				"State reset", 
				"State reset to initial state", 
				"String", 
				"Intermediate State", 
				"Initial State");
		sendNotification(acn);
	}
}
