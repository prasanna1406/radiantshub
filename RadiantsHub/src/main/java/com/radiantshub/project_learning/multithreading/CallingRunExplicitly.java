package com.radiantshub.project_learning.multithreading;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.radiantshub.logger.RadiantsLogger;

/**
 * 
 * 
 * @author vivek
 *
 *Learning - If we call run method explicitly then there will be no context switching between the thread
 *It will not considered as a thread
 *
 *It will goes into current method stack rather than from beginning of the stack
 */

public class CallingRunExplicitly {

	@Autowired 
	static JavaMailSender sender;

	public static void main(String[] args) throws InterruptedException {
		/*Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		System.out.println(t1.getName());
		System.out.println(t2.getId());
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println("Main methdo is also a thread");*/
		System.out.println(sender);
	}
}

class Thread1 extends Thread{
	Logger logger = RadiantsLogger.getLogger("newThread");
	public void run(){
		for(int i=0;i<=10;i++){
			
			try {
				/**
				 * This causes the stack overflow exception as run calls itself and no break option
				 */
				//Thread.currentThread().run();
				Thread.sleep(100);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				/*e.printStackTrace();*/
				logger.error("it works error");
				
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				/*e.printStackTrace();*/
				logger.error("it works error");
				
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " is running" + i);
		}
	}
}