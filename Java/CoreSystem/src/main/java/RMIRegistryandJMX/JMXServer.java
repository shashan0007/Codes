package RMIRegistryandJMX;

import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class JMXServer {
	private static final int RMI_PORT = 5432;

	public static void main(String[] args) {

		try {
			MBeanServer mbs = MBeanServerFactory.createMBeanServer();
			//waitForEnterPressed(); 
			String domain = mbs.getDefaultDomain();
			System.out.println("domain: " + domain);
			//waitForEnterPressed(); 
			String mBeanClassName = "StandardService";
			String mBeanObjectNameStr = domain + ":type=" + mBeanClassName + ",index=1";
			ObjectName mBeanObjectName = createMBeanObjectName(mbs,mBeanClassName,mBeanObjectNameStr);
			//waitForEnterPressed(); 
			printMBeanInfo(mbs,mBeanObjectName,mBeanClassName);
			//waitForEnterPressed();
			JMXClient notificationListener = JMXClient.getInstance();
			mbs.addNotificationListener(mBeanObjectName, notificationListener, null, null);
			
			Registry reg = LocateRegistry.createRegistry(RMI_PORT);
			
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:5432/server"); 
			JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs); 
			cs.start(); 
			waitForEnterPressed();
			
			cs.stop(); 
			
		}
		catch(Exception e) {
			System.out.println("Exception Thrown: " + e.getClass().getCanonicalName());
			e.printStackTrace();
		}
	
	}

	private static void printMBeanInfo(MBeanServer mbs, ObjectName mBeanObjectName, String mBeanClassName) throws IntrospectionException, InstanceNotFoundException, ReflectionException {
		
		MBeanInfo info = mbs.getMBeanInfo(mBeanObjectName);
		MBeanAttributeInfo[] attributes = info.getAttributes();
		if(attributes.length > 0) {
			for(int i = 0; i < attributes.length;i++) {
				System.out.println("Name: " + attributes[0].getName() );
				System.out.println("Description: " + attributes[0].getDescription());
				System.out.println("Type: " + attributes[0].getType());
				System.out.println("isReadable() : " + attributes[0].isReadable());
				System.out.println("isWritable() : " + attributes[0].isWritable());
			}
		}
		else {
			System.out.println("No Attributes for managed MBean: " + mBeanClassName);
		}

	}

	private static ObjectName createMBeanObjectName(MBeanServer mbs,String mBeanClassName, String mBeanObjectNameStr) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanRegistrationException, MBeanException, ReflectionException {
		
		ObjectName objName = ObjectName.getInstance(mBeanObjectNameStr);
		mbs.createMBean(StandardService.class.getCanonicalName(), objName);
		return objName;
	
	}
	
	private static void waitForEnterPressed() {
        try {
            System.out.println("Press  to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static Process startJMXServer() {
		
		String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java"; 
		String classPath = System.getProperty("java.class.path");
		String className = JMXServer.class.getCanonicalName();
		ProcessBuilder processBuilder = new ProcessBuilder(javaBin,"-cp",classPath, className);
		try {
			return processBuilder.start();
		} catch (IOException e) {
			System.out.println("Exception starting JMX server from Junit test");
			e.printStackTrace();
		}
		return null;	
	}
	
}

