package com.radiantshub.application;

public enum ApplicationEnvironment {

	PROD(1), DEV(2), UAT(3);
	
	int id;
	
	ApplicationEnvironment(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getBussinessName(){
		return this.name().toLowerCase();
	}
}
