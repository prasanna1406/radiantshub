package com.radiantshub.project_learning.multithreading;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
/**
 * 
 * @author perennial
 *Tree set is by default sorted because the Integer implements the comparable
 *When ever we override a method and pass a null value and if two objects are not inherited then it will give ambiguity
 */
public class SpringBean {

	public static void main(String[] args) {
		/*AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(ctx.getBean("sessionFactory"));*/
		
		TreeSet<Integer> t1 = new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		t1.add(1);
		t1.add(23);
		t1.add(3);
		t1.add(56);
		
		//v1(null);
		v1(null);
		System.out.println(null instanceof Object);
		System.out.println(t1);
		A a = new A();
		B b = new B();
		
		System.out.println(Runtime.getRuntime().freeMemory()/1024);
		
		/*b.main();*/
	}
	
	public static void v1(Number v){
		System.out.println("String");
	}
	
	public static void v1(Integer v){
		System.out.println("Integer");
	}

	
	/*public static void v1(Long v){
		System.out.println("long");
	}
	
	public static void v1(long... v){
		System.out.println("array long");
	}
	
	public static void v1(int v){
		System.out.println("array long");
	}
	
	public static void v1(long v){
		System.out.println("array long");
	}*/
	
	
	
	
}
class A{
	
	protected void main() throws IOException{
		System.out.println("parent");
	}
}

class B extends A{
	public void main()throws FileNotFoundException{
		System.out.println("parent");
	}
}
