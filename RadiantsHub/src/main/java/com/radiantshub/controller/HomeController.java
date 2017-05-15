package com.radiantshub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.radiantshub.entities.User;
import com.radiantshub.exceptions.RadiantsHubException;
import com.radiantshub.handler.RadiantsHandler;
import com.radiantshub.mail.MailContent;
import com.radiantshub.mail.MailHelper;
import com.radiantshub.mail.MailMapENUM;
import com.radiantshub.service.TestService;


// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 * @author vivek
 */
@Controller
public class HomeController {
	
	
	/** The handler. */
	@Autowired
	RadiantsHandler handler;
	
	@Autowired
	@Qualifier("getGmailSetting")
	private JavaMailSenderImpl mailSender;

	@Autowired
	private TestService test;
	
	@Autowired
	private HashMap<String, MailContent> mailContentMap;
	/**
	 * Gets the home page.
	 *
	 * @return the home page
	 * @throws RadiantsHubException the radiants hub exception
	 * @throws javax.mail.MessagingException 
	 * @throws MessagingException 
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getHomePage() throws RadiantsHubException, MessagingException, javax.mail.MessagingException{
		User user = new User();
		
		user.setPassword("bittu");
		user.setUsername("sharma");
		handler.saveUser(user);
		
		List<String> to = new ArrayList<String>();
		List<String> cc = new ArrayList<String>();
		List<String> bcc = new ArrayList<String>();
		
		to.add("vivekswansi@gmail.com");
		to.add("vivek.swansi@perennialsys.com");
		to.add("prasanna.wagh@perennialsys.com");
		
		cc.add("vivekswansi@gmail.com");
		cc.add("vivek.swansi@perennialsys.com");
		cc.add("prasanna.wagh@perennialsys.com");
		
		bcc.add("vivekswansi@gmail.com");
		bcc.add("vivek.swansi@perennialsys.com");
		bcc.add("prasanna.wagh@perennialsys.com");
		
		/*List<File> attachments = new ArrayList<File>();
		File file1 = new File("/home/perennial/newThread.log");
		attachments.add(file1);

		
		File file2 = new File("/home/perennial/radiantshub.log");
		attachments.add(file2);
		*/
		
		System.out.println("\n\n\n\n\n" + mailContentMap);
		for(Map.Entry<String, MailContent> entrySet : mailContentMap.entrySet()){
			System.out.println(entrySet.getKey() + "\n\n\n value \n" + entrySet.getValue());
		}
		
		MailHelper.sendMail(to.toArray(new String[to.size()]), bcc.toArray(new String[bcc.size()]), 
				cc.toArray(new String[cc.size()]), null,
				mailSender, mailContentMap.get(MailMapENUM.CREATE_PASSWORD.name()));
		test.displayService();
		
		System.out.println(mailContentMap);
		return new ModelAndView("index");
	}

	/*@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message) {
		System.out.println(message);
		return new OutputMessage(message, new Date());
	}
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greetings(HelloMessage message,Principal principal) {
		return new Greeting(" "+message.getName() + "<br> By- "+principal.getName());
	}*/
}
