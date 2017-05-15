package com.radiantshub.logger;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.radiantshub.configurations.AppConfig;
import com.radiantshub.configurations.HibernateConfiguration;

public class Test {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class, HibernateConfiguration.class);
		/*ctx.register(AppConfig.class);
		ctx.register(WebConfig.class);
		ctx.register(HibernateConfiguration.class);*/
		/*System.out.println(ctx);*/
		System.out.println(ctx.getBean("otherSetting"));
		
		
		/*Logger logger = RadiantsLogger.getLogger("thread1");
		
		Thread1 thread1 = new Thread1(logger);
		Thread1 thread2 = new Thread1(logger);
		Thread1 thread3 = new Thread1(logger);
		Thread1 thread4 = new Thread1(logger);
		Map<String,String> map = new HashMap<String, String>();
		map.put("f", "dsfdf");
		
		System.out.println(map.get("adf"));
		
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread3.setName("thread3");
		thread4.setName("thread4");
		System.out.println(System.getProperty("user.home"));*/
		/*thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		Thread t1 = new Thread(new Thread2());
		t1.start();*/
		
		/*String str = FileUtil.getBodyContent(MailHelper.mailContentMap.get(MailMapENUM.CREATE_PASSWORD.name()).getFileName(), null);
		
		str = str.replace("*|NAME|*", "vivek");
		
		System.out.println(str);*/
		
	}
}

class Thread1 extends Thread{
	
	Logger logger = null;
	
	public Thread1(Logger logger){
		this.logger = logger;
	}
	
	public void run(){
		
		logger.trace("trace");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("debug");
		logger.warn("warn");
	}
}


class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread implemebsrs");
	}
	
}