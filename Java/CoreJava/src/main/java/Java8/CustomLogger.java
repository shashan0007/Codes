package Corejava;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger {
	
	Logger logger = Logger.getGlobal();

	public static void main(String[] args) {
		CustomLogger tester = new CustomLogger();
		
		try {
			MyLogger.setup();
		}catch(RuntimeException rte){
			rte.printStackTrace();
		}
		tester.logSomething();
	}
	
	public void logSomething(){
		logger.fine("Fine Log");
		logger.severe("severe");
		logger.warning("warning");
		
		logger.setLevel(Level.WARNING);
		logger.fine("WARN: Fine Log");
		logger.severe("WARN: severe Log");
		logger.warning("WARN: warning Log");	
	}
}
class MyLogger {
	
	private static SimpleFormatter sFormatter;
	private static FileHandler txtFileHandler;
	
	private static Formatter htmlFormatter;
	private static FileHandler htmlFileHandler;
	
	public static void setup(){

		Logger rootLogger = Logger.getGlobal();
		Handler[] handlers = rootLogger.getHandlers();
		if( null != handlers && handlers.length > 0 ){
			System.out.println(handlers.length);
			if(handlers[0] instanceof ConsoleHandler){
				rootLogger.removeHandler(handlers[0]);
			}
		}
		rootLogger.setLevel(Level.FINE);
		
			try {
				txtFileHandler = new FileHandler("Log.txt");
				htmlFileHandler = new FileHandler("Log.html");
			} catch (SecurityException | IOException e1) {
				e1.printStackTrace();
			}
			try {
				sFormatter = new SimpleFormatter();
				txtFileHandler.setFormatter(sFormatter);
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		
		rootLogger.addHandler(txtFileHandler);
		
		htmlFormatter = new HTMLFormatter();
		htmlFileHandler.setFormatter(htmlFormatter);
		rootLogger.addHandler(htmlFileHandler);
	}	
}

class HTMLFormatter extends Formatter {

	@Override
	public String format(LogRecord rec) {
		
		StringBuffer rValue = new StringBuffer(1000);
		rValue.append("<tr>");
		
		if(rec.getLevel().intValue() >= Level.WARNING.intValue()) {
			rValue.append("<td style = \"font-color:red\" ");
			rValue.append(rec.getLevel());
			rValue.append("<\td> \t");
			rValue.append("<td>");
			rValue.append(rec.getMillis());
			rValue.append("<\td> \t");
			rValue.append("<td>");
			rValue.append(formatMessage(rec));
			rValue.append("<\td> \t");
		}
		else {
			rValue.append("<td>");
			rValue.append(rec.getLevel());	
			rValue.append("<\td> \t");
			rValue.append("<td>");
			rValue.append(rec.getMillis());
			rValue.append("<\td> \t");
			rValue.append("<td>");
			rValue.append(formatMessage(rec));
			rValue.append("<\td> \t");
		}
		rValue.append("</tr> \n");
		return rValue.toString();
	}
	
	@Override
	public String getHead(Handler h){
		
		StringBuffer headString = new StringBuffer(1000);
		headString.append("<!doctype html>");
		headString.append("<head><title>Ashish</title></head>");
		headString.append("<body>");
		headString.append("<table>");
		
		headString.append("<tr>");
		headString.append("<td>");
		headString.append("Level");
		headString.append("</td>");
		headString.append("<td>");
		headString.append("MilliSeconds");
		headString.append("</td>");
		headString.append("<td>");
		headString.append("Message");
		headString.append("</td>");
		headString.append("</tr>");
		return headString.toString();
	}
	
	@Override
	public String getTail(Handler h){
		return "</table>\n</body>\n</html>";
	}
}
