package com.radiantshub.application;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.radiantshub.constant.ApplicationLvlConstants;
import com.radiantshub.logger.RadiantsLogger;
import com.radiantshub.util.StringUtil;

class ApplicationConstants {

	private static Logger logger = RadiantsLogger.getLogger(ApplicationConstants.class);
	
	public static void setAppLevelConstants(String env){
		ApplicationConfig config = ApplicationConfig.getInstance();
		
		config.setEnvironment(env);
		
		//Development environment
		if(config.getEnvironment().equalsIgnoreCase(ApplicationEnvironment.DEV.name())){
			
		}
		//UAT environment
		else if(config.getEnvironment().equalsIgnoreCase(ApplicationEnvironment.UAT.name())){
			
		}
		//Production environment
		else{
			
		}
	}

	public static String getApplicationEnvironment(String envPropertyKey, String appEnv) {
		
		InitialContext ictx;
		try {
			ictx = new InitialContext();
			Context ctx = (Context)ictx.lookup(ApplicationLvlConstants.JAVA_ENV);
			if(!StringUtil.isBlank(String.valueOf(ctx.lookup(envPropertyKey)))){
				appEnv = String.valueOf(ctx.lookup(envPropertyKey));
			}
		} catch (NamingException e) {
			logger.error(""+e);
		}
		
		return appEnv;
	}
	
	
}
