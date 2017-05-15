package com.radiantshub.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileUtil {

	private static String defaultPath = System.getProperty("user.home");
	
	
	public static String getBodyContent(String fileName, Map<String, Object> bodyToReplace){
		String currentLine;
		String bodyContent = "" ;
		if(!defaultPath.substring(defaultPath.length()-1).equalsIgnoreCase("/")){
			defaultPath += "/"; 
		}
		
		String filePath = defaultPath + "radiantshub/emailtemplates/" + fileName;
		File file = new File(filePath);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			while((currentLine=br.readLine())!=null){
				bodyContent+=currentLine;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bodyContent = replaceString(bodyToReplace, bodyContent);
		
		return bodyContent;
	}
	
	
	public static String replaceString(Map<String, Object> bodyToReplace, String replacingContent){
		
		
		
		for(Map.Entry<String, Object> entrySet : bodyToReplace.entrySet()){
			System.out.println(entrySet.getKey() + "\n\n String to replace\n\n" + entrySet.getValue());
			replacingContent = replacingContent.replace(entrySet.getKey(), String.valueOf(entrySet.getValue()));
			
		}
		
		return replacingContent;
	}


}
