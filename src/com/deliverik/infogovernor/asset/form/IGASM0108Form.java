package com.deliverik.infogovernor.asset.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 资产下拉数据选择画面FORM
 * 
 */
public class IGASM0108Form extends BaseForm implements SOC0151Info{

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
	
	/** 资产下拉数据值集合*/
	protected String[] ccdvalues;
	
	/** 资产项配置值最大字节数 */
	private static final int MAX_BYTE = 32;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
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
	/**
	 * 数据值最大长度检测
	 *
	 * @param mapping
	 * @param request
	 * @return 检测错误信息
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		errors = super.validate(mapping, request);
		if ( ccdvalues != null ) {
			for ( int i=0;i<ccdvalues.length;i++ ) {
				if (!IGStringUtils.isValidBytes(ccdvalues[i],MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.maxbytes","(编号：" +ccdvalues[i]+")的数据值", 
    					String.valueOf(MAX_BYTE / 3), String.valueOf(MAX_BYTE)));
				}
			}
		}
		
		request.getSession().setAttribute("IGASM0108Form", this);
		return errors;
	}

}
