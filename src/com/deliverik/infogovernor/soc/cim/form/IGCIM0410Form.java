package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���������ѡ����FORM
 * 
 */
public class IGCIM0410Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	private String ccdcategory;
	
	private String ccdid;
	
	private String ccdvalue;

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdid() {
		return ccdid;
	}

	public void setCcdid(String ccdid) {
		this.ccdid = ccdid;
	}

	public String getCcdvalue() {
		return ccdvalue;
	}

	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}
	
}
