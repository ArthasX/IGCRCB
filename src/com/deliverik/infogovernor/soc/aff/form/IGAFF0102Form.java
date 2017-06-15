package com.deliverik.infogovernor.soc.aff.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸Ӱ���������FORM
 * 
 */
public class IGAFF0102Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �豸���� */
	protected String einame;

	/** �豸����ʱ��FROM */
	protected String eiupdtime_from;

	/** �豸����ʱ��TO */
	protected String eiupdtime_to;

	/** �ʲ�������ģ�� */
	protected String esyscoding;

	/** �ʲ�ģ���� */
	protected String ename;

	protected String topCi;

	protected Integer eiid;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getTopCi() {
		return topCi;
	}

	public void setTopCi(String topCi) {
		this.topCi = topCi;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}
