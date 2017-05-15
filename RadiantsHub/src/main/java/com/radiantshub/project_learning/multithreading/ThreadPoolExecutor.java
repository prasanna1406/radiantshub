package com.radiantshub.project_learning.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author vivek
 *So the advantage of the connection pool is explained below
 *Consider we have multiple request, so to avoid again and again creation of connection it get the connection from the pool 
 *if connection is not available then it creates a new connection and put in pool according to the configuration
 *if it reached the maximum allowed connection then request will wait in the queue.
 *
 *Same as above the Thread pool also does the same task
 *
 *Creating a new thread on each request may slow down the request processing speed.
 *Opening and maintaining a database connection for each user, especially requests made to a dynamic database-driven Web application,
 *is costly and wastes resources. In connection pooling, after a connection is created, it is placed in the pool and 
 *it is used over again so that a new connection does not have to be established. If all the connections are being used, 
 *a new connection is made and is added to the pool. 
 *Connection pooling also cuts down on the amount of time a user must wait to establish a connection to the database.
 *
 */
public class ThreadPoolExecutor {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			Worker work = new Worker();
			work.setName(String.valueOf(i));
			threadPool.execute(work);
		}
		
		threadPool.shutdown();
		
		/*while(!threadPool.isTerminated()){
			System.out.println("Thread still go");
		}*/
		System.out.println("Finish all thread");
	}
}


class Worker extends Thread{
	
	public void run(){
		
		System.out.println("Thread " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread ended" + Thread.currentThread().getName());
	}
}

class Ex implements Executor{

	@Override
	public void execute(Runnable paramRunnable) {
		// TODO Auto-generated method stub
		
	}
	
}