package com.radiantshub.mail;

public enum MailMapENUM {

	CREATE_PASSWORD(1), CHANGE_PASSWORD(2);
	
	int id;
	
	private MailMapENUM(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}
}
