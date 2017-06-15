package com.deliverik.framework.hibernate;

public class HibernateUtilException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HibernateUtilException() {
		super ();
	}

	public HibernateUtilException(String message, Throwable cause) {
		super (message, cause);
	}

	public HibernateUtilException(String message) {
		super (message);
	}

	public HibernateUtilException(Throwable cause) {
		super(cause);
	}
}

