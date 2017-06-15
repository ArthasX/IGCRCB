package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���������ѡ����FORM
 * 
 */
public class IGDRM0417Form extends BaseForm implements IG545SearchCond{

	private static final long serialVersionUID = 1L;
	
	/** �ʲ���������ID*/
	protected Integer ccdid;
	
	/** �ʲ��������ݱ�ʶ */
	protected String ccdcategory;
	
	/** �ʲ��������ݱ�ʶ����*/
	protected String ccdlabel;
	
	/** �ʲ���������ֵ*/
	protected String ccdvalue;
	
	/** �ʲ���������״̬*/
	protected String ccdstatus;
	
	/** �ʲ�������������Ӧ��*/
	protected String ccdtype;
	
	/** �ʲ���������Ԥ���ֶ�*/
	protected String ccdinfo;

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
