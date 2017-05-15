package com.radiantshub.project_learning.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsumerProducerThread {
	public static void main(String[] args) {

		List<String> sharedQueue = new  ArrayList<String>();

		/*Consumer con = new Consumer(sharedQueue);
		
		Producer producer1 = new Producer(sharedQueue);
		Producer producer2 = new Producer(sharedQueue);
		Producer producer3 = new Producer(sharedQueue);
		Producer producer4 = new Producer(sharedQueue);

		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		con.start();*/
		
		final ConsumerProducer con = new ConsumerProducer(sharedQueue);
		new Thread1(){
			public void run(){
				con.consumeData();
			}
		}.start();
		
		new Thread1(){
			public void run(){
				con.consumeData();
			}
		}.start();
		
		
		new Thread1(){
			public void run(){
				con.consumeData();
			}
		}.start();
		
		new Thread1(){
			public void run(){
				con.produceData();
			}
		}.start();
		


	}
}

class Consumer extends Thread{
	private int MIN_SIZE = 0;
	private List<String> queue;

	public Consumer(List<String> queue){
		this.queue = queue;
	}

	/*private synchronized void consumeData(){

		while(true){
			if(this.queue.size()==MIN_SIZE){
				try {
					System.out.println("consumer " + Thread.currentThread().getName() + "is waiting for producer to producer");
					queue.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{

				System.out.println(queue.remove(0) + " is removed");
				queue.notify();
			}
		}

	}*/

	public void run(){
		//consumeData();
		synchronized (queue) {
			while(true){
				if(this.queue.size()==MIN_SIZE){
					try {
						System.out.println("consumer " + Thread.currentThread().getName() + "is waiting for producer to producer");
						queue.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{

					System.out.println(queue.remove(0) + " is removed");
					queue.notify();
				}
			}
		}
	}
}


class Producer extends Thread{
	private int MAX_SIZE = 10;
	private List<String> queue;

	public Producer(List<String> queue){
		this.queue = queue;
	}

	/*private synchronized void produceData(){



	}*/

	public void run(){
		synchronized (queue) {
			while(true){
				if(this.queue.size()>=MAX_SIZE){
					try {
						System.out.println("producer " + Thread.currentThread().getName() + "is waiting for consumer to consume");
						queue.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{

					String data = String.valueOf(new Random().nextInt(100));
					queue.add( data );
					System.out.println( data + "produced" );
					//queue.notify();
				}
			}
		}
	}
}



class ConsumerProducer{
	
	private List<String> queue;
	private int MIN_SIZE = 0;
	private int MAX_SIZE = 10;
	
	
	public ConsumerProducer(List<String> queue){
		this.queue = queue;
	}
	
	public synchronized void consumeData(){

		while(true){
			if(this.queue.size()==MIN_SIZE){
				try {
					System.out.println("consumer " + Thread.currentThread().getName() + "is waiting for producer to producer");
					this.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{

				System.out.println(queue.remove(0) + " is removed");
				this.notify();
			}
		}
	}
	
	
	public synchronized void produceData(){

		while(true){
			if(this.queue.size()>=MAX_SIZE){
				try {
					System.out.println("producer " + Thread.currentThread().getName() + " is waiting for consumer to consume");
					this.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{

				String data = String.valueOf(new Random().nextInt(100));
				queue.add( data );
				System.out.println( data + "produced" );
				this.notify();
			}
		}
	}
}