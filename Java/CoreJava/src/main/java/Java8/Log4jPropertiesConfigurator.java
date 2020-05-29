package Corejava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPropertiesConfigurator {
	
	private static Logger LOGGER = Logger.getLogger(Log4jPropertiesConfigurator.class);
	private static Log4jPropertiesConfigurator l4jpc = new Log4jPropertiesConfigurator();
	
	private Log4jPropertiesConfigurator(){
		LOGGER.info("Creating new Object in constructor");
	}
	
	private static void initilizeLogger(){
		LOGGER.info("Logging before setting properties");
		Properties logProperties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/log4j2.properties");
			logProperties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(logProperties);
		LOGGER.info("Ending initializeLogger: With properties");
	}
	
	public static void main(String args[]){
		initilizeLogger();
		LOGGER.info("Into main");
		LOGGER.debug("Debug trace main");
	}
	public static Logger getLogger() {
		return LOGGER;
	}
}
