package com.radiantshub.exceptions;

public class RadiantsHubException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4986824057966033557L;

	private String errorCode;
	private String errorMessage;
	private Throwable throwable;


	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}


	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}


	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}


	/**
	 * @param throwable the throwable to set
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}


	/**
	 *Default constructor 
	 */
	public RadiantsHubException() {
		super();
	}


	/**
	 * @param paramString
	 * @param paramThrowable
	 */
	public RadiantsHubException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
		this.errorMessage = paramString;
		this.throwable = paramThrowable;

	}


	/**
	 * @param paramString
	 */
	public RadiantsHubException(String paramString) {
		super(paramString);
		this.errorMessage = paramString;

	}


	/**
	 * @param paramThrowable
	 */
	public RadiantsHubException(Throwable paramThrowable) {
		super(paramThrowable);
		this.throwable = paramThrowable;

	}


	/**
	 * @param errorCode
	 * @param errorMessage
	 * @param throwable
	 */
	public RadiantsHubException(String errorCode, String errorMessage, Throwable throwable) {
		super(errorMessage,throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.throwable = throwable;

	}


	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public RadiantsHubException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


}
