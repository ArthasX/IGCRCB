/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;

public class IGSDL0110Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String qjassetid;
	private String qjassettypeid;
	private String qjassetname;
	private String qjassettypename;
	private String qjtype_q;
	private String qjstatus;

	private String date;
	private String date_j;
	private String ymonth;
	private String date_now;
	
	public String getQjstatus() {
		return qjstatus;
	}

	public void setQjstatus(String qjstatus) {
		this.qjstatus = qjstatus;
	}

	public String getQjtype_q() {
		return qjtype_q;
	}

	public void setQjtype_q(String qjtype_q) {
		this.qjtype_q = qjtype_q;
	}

	public String getQjassetid() {
		return qjassetid;
	}

	public void setQjassetid(String qjassetid) {
		this.qjassetid = qjassetid;
	}

	public String getQjassettypeid() {
		return qjassettypeid;
	}

	public void setQjassettypeid(String qjassettypeid) {
		this.qjassettypeid = qjassettypeid;
	}

	public String getQjassetname() {
		return qjassetname;
	}

	public void setQjassetname(String qjassetname) {
		this.qjassetname = qjassetname;
	}

	public String getQjassettypename() {
		return qjassettypename;
	}

	public void setQjassettypename(String qjassettypename) {
		this.qjassettypename = qjassettypename;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYmonth() {
		return ymonth;
	}

	public void setYmonth(String ymonth) {
		this.ymonth = ymonth;
	}

	public String getDate_j() {
		return date_j;
	}

	public void setDate_j(String date_j) {
		this.date_j = date_j;
	}

	public String getDate_now() {
		return date_now;
	}

	public void setDate_now(String date_now) {
		this.date_now = date_now;
	}

}
