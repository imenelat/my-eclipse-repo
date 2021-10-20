package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	
	static Logger logger=LogManager.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
		logger.info("This is info");
		logger.error("This is an error");
		logger.warn("This is a warning");
		logger.fatal("This is a fatal");
		
	}

}
