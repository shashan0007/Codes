package RMIRegistryandJMX;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXClient implements NotificationListener {

	private static JMXClient instance;

	public void handleNotification(Notification notification, Object sender) {
		System.out.println("Received Notification from Server" + notification);
		System.out.println("Notification Class : " + notification.getClass().getCanonicalName());
		if(AttributeChangeNotification.class.isInstance(notification)) {
			System.out.println("Some Attribute is Changed");
			String.format(Locale.FRENCH, "TimeStamp", notification.getTimeStamp());
		}
	}
	
	private JMXClient() {}

	public static JMXClient getInstance() {
		if(instance == null) {
			instance = new JMXClient();
		}
		return instance;
	}

	public void start() {
		JMXServiceURL url;
		try {
			url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:5432/server");
			JMXConnector clientConnector = JMXConnectorFactory.connect(url);
			MBeanServerConnection mbsc = clientConnector.getMBeanServerConnection();
			String defaultDomain = mbsc.getDefaultDomain();
			System.out.println("MBSC: default domain -> " + defaultDomain);

			Set<ObjectName> mBeanNames = mbsc.queryNames(null, null);
			for (Iterator<ObjectName> i = mBeanNames.iterator(); i.hasNext(); ) { 
				ObjectName obj = (ObjectName) i.next();
				//if(obj.)
				System.out.println("ObjectName = " + obj); 
				//mbsc.invoke(obj,"reset",null,null);
			}
			clientConnector.close();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getClass().getCanonicalName());
			e.printStackTrace();
		}  
	}

}
