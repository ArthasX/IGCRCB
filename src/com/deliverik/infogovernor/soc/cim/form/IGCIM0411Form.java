package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseForm;

/**
 * 资产下拉数据选择画面FORM
 * 
 */
public class IGCIM0411Form extends BaseForm implements IG545Info{

	private static final long serialVersionUID = 1L;
	
	/** 资产下拉数据ID*/
	protected Integer ccdid;
	
	/** 资产下拉数据标识 */
	protected String ccdcategory;
	
	/** 资产下拉数据标识名称*/
	protected String ccdlabel;
	
	/** 资产下拉数据值*/
	protected String ccdvalue;
	
	/** 资产下拉数据状态*/
	protected String ccdstatus;
	
	/** 资产下拉数据所属应用*/
	protected String ccdtype;
	
	/** 资产下拉数据预留字段*/
	protected String ccdinfo;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** 资产下拉数据值集合*/
	protected String[] ccdvalues;
	
	public String[] getCcdvalues() {
		return ccdvalues;
	}

	public void setCcdvalues(String[] ccdvalues) {
		this.ccdvalues = ccdvalues;
	}

	public Integer getCcdid() {
		return ccdid;
	}

	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdlabel() {
		return ccdlabel;
	}

	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

	public String getCcdvalue() {
		return ccdvalue;
	}

	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	public String getCcdstatus() {
		return ccdstatus;
	}

	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	public String getCcdtype() {
		return ccdtype;
	}

	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

	public String getCcdinfo() {
		return ccdinfo;
	}

	public void setCcdinfo(String ccdinfo) {
		this.ccdinfo = ccdinfo;
	}
	

}
