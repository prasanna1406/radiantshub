package com.radiantshub.beans;

public class Message {

	private String message;
	private int id;
	
	public Message() {
		super();
	}

	public Message(String message, int id) {
		super();
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
