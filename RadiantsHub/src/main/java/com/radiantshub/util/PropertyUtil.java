package com.radiantshub.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * The class read all property from the file and exports to its property.
 * The class minimize the effort to add each property manually.
 * 
 * @author vivek
 *
 */

public class PropertyUtil {


	private PropertyUtil() {

	}

	public static Properties getProperties(String fileName) {
		InputStream addrStream = null;
		Properties properties = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			addrStream=classLoader.getResourceAsStream(fileName + ".properties");
			if(addrStream!=null){
				properties = new Properties();
				properties.load(addrStream);
			}
			System.out.println(properties);
		} catch (Exception e) {
			//XeroLogger.error(CLASS_NAME, "Error in PropertyUtility Static block : ", e, true);
		} finally {
			try {
				if (addrStream != null) {
					addrStream.close();
				}
			} catch (Exception e) {
				//XeroLogger.error(CLASS_NAME, "Static Block", "error in PropertyUtility finally block");
			}
		}
		return properties;
	}
}