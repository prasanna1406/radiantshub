/*package com.radiantshub.mail;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.radiantshub.constant.RadiantsHubConstants;
import com.radiantshub.util.PropertyUtil;

public class MailHelperMap {

	public static Map<String, MailSubjectBody> mailContentMap = new HashMap<String, MailSubjectBody>();

	static {
		Properties mailProperties = PropertyUtil.getProperties(RadiantsHubConstants.EMAIL_PROPERTIES);
		mailContentMap.put(MailMapENUM.CREATE_PASSWORD.name(), new MailSubjectBody(mailProperties.getProperty("password.generate.subject"), 
				mailProperties.getProperty("password.generate.filename")));

		mailContentMap.put(MailMapENUM.CHANGE_PASSWORD.name(), new MailSubjectBody(mailProperties.getProperty("password.change.subject"), 
				mailProperties.getProperty("password.change.filename")));
	}
}
*/