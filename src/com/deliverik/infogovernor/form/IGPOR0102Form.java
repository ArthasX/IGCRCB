package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 主菜单画面用FORM
 * 
 * @author 
 * 
 */
@SuppressWarnings("serial")
public class IGPOR0102Form extends BaseForm {

	/**  */
	protected String linkID;
	protected String year;
	protected String month;
	protected String forward;
	protected String prtype;
	protected String date;
	protected String curmonth;
	protected String curyear;
	protected String srname;
	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}
	/**
	 * 
	 * @return 
	 */
	public String getLinkID() {
		return linkID;
	}

	/**
	 * 
	 * @param linkID 
	 */
	public void setLinkID(String linkID) {
		this.linkID = linkID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCurmonth() {
		return curmonth;
	}

	public void setCurmonth(String curmonth) {
		this.curmonth = curmonth;
	}

	public String getCuryear() {
		return curyear;
	}

	public void setCuryear(String curyear) {
		this.curyear = curyear;
	}
}
