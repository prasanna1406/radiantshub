package com.radiantshub.logger;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.radiantshub.util.PropertyUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class RadiantsLogger.
 */
public class RadiantsLogger {

	/** The log 4 j configurations. */
	private static Properties log4jConfigurations;
	
	/** The logger levels. */
	private static Map<String, Level> loggerLevels = new HashMap<String, Level>();
	
	/** The logger level. */
	private static Level loggerLevel;
	static{
		loggerLevels.put("ALL", Level.ALL);
		loggerLevels.put("DEBUG", Level.DEBUG);
		loggerLevels.put("ERROR", Level.ERROR);
		loggerLevels.put("FATAL", Level.FATAL);
		loggerLevels.put("INFO", Level.INFO);
		loggerLevels.put("OFF", Level.OFF);
		loggerLevels.put("TRACE", Level.TRACE);
		loggerLevels.put("WARN", Level.WARN);
		
		log4jConfigurations = PropertyUtil.getProperties("log4jConfig");
		rootPath = System.getProperty(log4jConfigurations.getProperty("log4j.appender.file.File")) + File.separator + log4jConfigurations.getProperty("log4j.appender.file.DeaultPath");
		loggerLevel = loggerLevels.get(log4jConfigurations.getProperty("log4j.level"));
	}
	
	/** Root path to log files. */
	private static String rootPath;
	
	/** The Constant loggers. */
	private static final Map<String, Logger> loggers = Collections.synchronizedMap(new HashMap<String, Logger>());
	
	
	/**
	 * Gets the logger which is custom Apache Log4j logger, which makes log files on daily basis.
	 *
	 * @param name the name
	 * @return the logger
	 */
	public static synchronized Logger getLogger(String name){
		Logger logger = loggers.get(name);
		if(logger == null){
			logger = LogManager.getLogger(name);
			
			//logger.setLevel(Level.ALL);
			if(loggerLevel!=null){
				logger.setLevel(loggerLevel);
			}
			else{
				logger.setLevel(Level.OFF);
			}
			
			String filePath = rootPath;
			filePath += File.separator + name+ ".log";
			try {
				
				Layout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
				Appender appender = new DailyRollingFileAppender(layout, filePath, "'.'dd-MM-yyyy");
				
				logger.addAppender(appender);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			loggers.put(name, logger);
		}
		return logger;
	}
	
	
	/**
	 * Gets the logger.
	 *
	 * @param clazz the clazz
	 * @return the logger
	 */
	public static synchronized Logger getLogger(Class<?> clazz){
		String name = clazz.getSimpleName();
		Logger logger = loggers.get(name);
		if(logger == null){
			logger = LogManager.getLogger(name);
			
			if(loggerLevel!=null){
				logger.setLevel(loggerLevel);
			}
			else{
				logger.setLevel(Level.OFF);
			}
			
			String filePath = rootPath;
			filePath += File.separator + name+ ".log";
			try {
				
				Layout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss,SSS zz} %m%n");
				Appender appender = new DailyRollingFileAppender(layout, filePath, "'.'dd-MM-yyyy");
				logger.addAppender(appender);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			loggers.put(name, logger);
		}
		return logger;
	}
	
	/**
	 * Removes the logger.
	 *
	 * @param eventId the event id
	 */
	public static void removeLogger(String eventId){
		loggers.remove(eventId);
	}

	
	/**
	 * Clear all loggers.
	 */
	public static void clearAllLoggers(){
		synchronized (loggers) {
			loggers.clear();
		}
	}
}
