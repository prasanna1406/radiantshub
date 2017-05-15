package com.radiantshub.project_learning.multithreading;

public class StringManipulation extends MYClass{

	public StringManipulation(int x){
		
	}
	public static void main(String[] args) {
		String a = "this is java";
		
		/*String b = a;
		System.out.println(b.replace('i', 's'));
		String c = a;
		System.out.println(c.replaceAll("is", "java"));
		
		String d = a;
		System.out.println(d.replaceFirst("is", "java"));*/
		
		new StringManipulation(6);
	}

	@Override
	public void display(int i) {
		System.out.println("In main" + i);
		
	}
}

abstract class MYClass{
	int z;
	
	public MYClass(){
		this.display(z);
	}
	
	public abstract void display(int i);
}


