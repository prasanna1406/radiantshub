/*package com.radiantshub.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.radiantshub.exceptions.RadiantsHubException;

// TODO: Auto-generated Javadoc
*//**
 * The Class JsonPathReader.
 * @author musaddique
 *//*
public class JsonPathReader {	

	*//** The document. *//*
	Object document = null;   

	*//**
	 * Gets the valueof json path.
	 *
	 * @param jsonPath the json path
	 * @return the valueof json path
	 *//*
	public String getValueofJsonPath(String jsonPath) {
		String value = null;
		try {
			if (document == null) {
				System.out.println(" Json is not loaded");
				return value;
			}
			jsonPath = "$." + jsonPath;

			Object attrValue = JsonPath.read(document, jsonPath);
			if (attrValue != null) {
				if (attrValue.getClass() == net.minidev.json.JSONArray.class) {
					net.minidev.json.JSONArray objArr = (net.minidev.json.JSONArray) attrValue;
					if (objArr.size() > 0) {
						if (objArr.get(0) != null) {
							value = objArr.get(0).toString();
						} else {
							value = null;
						}
					}
				} else {
					value = String.valueOf(attrValue);
				}
			}
		} catch (Exception ex) {
			value = null;
		}
		return value;
	}

	*//**
	 * Load json.
	 *
	 * @param json the json
	 *//*
	public void loadJson(String json) {
		document = Configuration.defaultConfiguration().jsonProvider().parse(json);
	}


	*//**
	 * Gets the all valueof json path.
	 *
	 * @param jsonPath the json path
	 * @return the all valueof json path
	 *//*
	public List<String> getAllValueofJsonPath(String jsonPath) {
		String value = null;
		List<String> list = new ArrayList<>();
		try {
			if (document == null) {
				System.out.println(" Json is not loaded");
				return list;
			}
			jsonPath = "$.." + jsonPath;

			Object attrValue = JsonPath.read(document, jsonPath);
			if (attrValue != null) {
				if (attrValue.getClass() == net.minidev.json.JSONArray.class) {
					net.minidev.json.JSONArray objArr = (net.minidev.json.JSONArray) attrValue;
					if (objArr.size() > 0) {
						int cnt = 0;
						while (cnt < objArr.size()) {
							if (objArr.get(cnt) != null) {
								list.add(objArr.get(cnt).toString());
							} else {
								list.add(null);
							}
							cnt++;
						}
					}
				} else {

					list.add(String.valueOf(attrValue));
				}
			}
		} catch (Exception ex) {

		}
		return list;
	}

	public static String getObjectAsJson(Object object) throws RadiantsHubException
	{
		ObjectMapper mapper = new ObjectMapper();

		//Object to JSON in String
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RadiantsHubException("Unable to read the json");
		}
	}

	public Object getValueofJsonPath1(JsonNode node, String jsonPath) {
     JsonNode childNode = node;        
     if(jsonPath.contains(DOT)){            
     String [] pathDetails =  jsonPath.split("\\.");
     {               
     for (String pathDetail : pathDetails) {
     if(pathDetail.contains("["))
     {
     int startInd = pathDetail.indexOf("[");
     String arrayPath= pathDetail.substring(0, startInd);
     System.out.println(" []"+ arrayPath );
     childNode = childNode.path(arrayPath);
     int keyInd= pathDetail.indexOf(":",startInd);



     //pathDetail=substr;
     }
     else{
     childNode = childNode.path(pathDetail);
     }
     }
     }
     }
     else{
     childNode = node.path(jsonPath);
     }
     return childNode.asText();
     }
	 
}
*/