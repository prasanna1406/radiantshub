package com.radiantshub.application;

import com.radiantshub.constant.ApplicationLvlConstants;

public class ApplicationConfig {

	private static ApplicationConfig appConfig;
	
	private String environment;
	
	private ApplicationConfig(){
		
	}
	
	public static synchronized ApplicationConfig getInstance(){
		if(appConfig==null){
			appConfig = new ApplicationConfig();
			ApplicationConstants.setAppLevelConstants(ApplicationConstants.
					getApplicationEnvironment(ApplicationLvlConstants.ENV_PROPERTY_KEY,
							ApplicationLvlConstants.DEFAULT_ENV));
			
		}
		
		return appConfig;
	}

	public String getEnvironment() {
		return environment;
	}

	void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
