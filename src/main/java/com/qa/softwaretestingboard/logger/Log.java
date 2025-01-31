package com.qa.softwaretestingboard.logger;


//import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;


public class Log {
	
	
private static final Logger logger = (Logger) LogManager.getLogger(Log.class);

		public static void info(String message) {
			logger.info(message);
		}

		public static void error(String message) {
			logger.error(message);
		}

		public static void error(String message, Exception e) {
			logger.error(message, e);
		}

		public static void debug(String message) {
			logger.debug(message);
		}

		public static void warn(String message) {
			logger.warn(message);
		}
	}






