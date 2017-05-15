package com.radiantshub.project_learning.multithreading;

/**
 * 
 * @author vivek
 *
 *Learning - Daemon thread is a light weight process which runs at background
 *If a user thread completes the daemon thread will terminates by jvm. It will not wait for the task to complete
 *finalize will call by the gc before the object claim by the gc to destroy
 *
 *Whenever you run a java program, JVM creates three threads. 1) main thread   2) Thread Scheduler   3) Garbage Collector Thread. 
 *In these three threads, 
 *main thread is a user thread and remaining two are daemon threads which run in background.
 *
 *cleanup operation includes closing database connection, closing file etc are some examples;
 */
public class DaemonThread {

	public static void main(String[] args) throws Throwable {
		
		Daemon t1 = new Daemon();
		t1.setDaemon(true);
		t1.start();
		Daemon t2 = new Daemon();
		Daemon t3 = new Daemon();
		t2.start();
		/*t3.start();
		
		
		String str = "vivek";
		
		DaemonThread tt1 = new DaemonThread();
		tt1.finalize();
		
		
		System.out.println(tt1.hashCode());*/
	}
	
	/*@Override
	protected void finalize() throws Throwable{
		super.finalize();
	}*/

}

class Daemon extends Thread{
	
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().isDaemon());
	}
}