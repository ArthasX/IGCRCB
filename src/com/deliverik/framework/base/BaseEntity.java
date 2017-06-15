package com.deliverik.framework.base;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;


import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Base entity class.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity implements BaseModel {
	
	protected String fingerPrint;
	
	

	public String getFingerPrint() {
		return fingerPrint;
	}


	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}


	/**
	 * 
	 * @return 
	 */
	public abstract Serializable getPK();


	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
