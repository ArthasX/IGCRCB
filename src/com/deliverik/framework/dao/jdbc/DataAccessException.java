package com.deliverik.framework.dao.jdbc;

public class DataAccessException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 842584198953334288L;
	private String message;
	private Throwable t;
	
	public DataAccessException(String message, Throwable t)
	{
		super(message);
		this.t = t;
	}
	
	public DataAccessException(Throwable t)
	{
		super();
		this.t = t;
	}
	
	public DataAccessException(String message)
	{
		super(message);		
	}
	
	public String getExceptionMessage() {
		return message;
	}
	
	public Throwable getExceptionThrowable() {
		return t;
	}
}
