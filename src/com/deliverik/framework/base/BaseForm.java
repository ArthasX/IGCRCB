package com.deliverik.framework.base;

import org.apache.struts.validator.ValidatorForm;

/**
 * Base form class.
 *
 */
public class BaseForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	/**  */
	protected String upddate;

	/**  */
	protected String updtime;

	/**  */
	protected String hdn_default_value;


	/**  */
	public String linkID;
	
	protected int fromCount;

	public int getFromCount() {
		return fromCount;
	}


	public void setFromCount(int fromCount) {
		this.fromCount = fromCount;
	}

	public String getLinkID() {
		return linkID;
	}

	public void setLinkID(String linkID) {
		this.linkID = linkID;
	}



	/**
	 * 
	 * @return 
	 */
	public String getUpddate() {
	    return upddate;
	}

	/**
	 * 
	 * @param upddate 
	 */
	public void setUpddate(String upddate) {
	    this.upddate = upddate;
	}

	/**
	 * 
	 * @return 
	 */
	public String getUpdtime() {
	    return updtime;
	}

	/**
	 * 
	 * @param updtime 
	 */
	public void setUpdtime(String updtime) {
	    this.updtime = updtime;
	}

	/**
	 * 
	 * @return 
	 */
	public String getHdn_default_value() {
		return hdn_default_value;
	}

	/**
	 * 
	 * @param hdn_default_value 
	 */
	public void setHdn_default_value(String hdn_default_value) {
		this.hdn_default_value = hdn_default_value;
	}


}
