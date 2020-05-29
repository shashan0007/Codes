package Corejava;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jBasicConfigurator {
	
	private static Logger LOGGER = Logger.getLogger(Log4jBasicConfigurator.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		LOGGER.debug("Debug Trace");
		LOGGER.info("info trace");
		LOGGER.fatal("fatal trace");
		LOGGER.warn("Warn trace");
		LOGGER.error("error trace");
	}

}
