package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGDRM1701Form extends BaseForm {
	
	/** ��ѵ��¼id */
	protected Integer trid;
	
	/** ��ѵ���� */
	protected String trnameLike;
	/** ��ѵ���� */
	protected String trname;

	/** ��ѵ��ʼʱ����ʼ */
	protected String trstimeFrom;
	
	/** ��ѵ��ʼʱ����ֹ */
	protected String trstimeTo;

	/** �鿴ģʽ(1:�鿴else ����) */
	protected String mode;

	/** ɾ����ѵ��¼���� */
	protected String[] deleteTrid;

	/**
	 * @return the trid
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * @param trid the trid to set
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * @return the trnameLike
	 */
	public String getTrnameLike() {
		return trnameLike;
	}

	/**
	 * @param trnameLike the trnameLike to set
	 */
	public void setTrnameLike(String trnameLike) {
		this.trnameLike = trnameLike;
	}

	/**
	 * @return the trname
	 */
	public String getTrname() {
		return trname;
	}

	/**
	 * @param trname the trname to set
	 */
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**
	 * @return the trstimeFrom
	 */
	public String getTrstimeFrom() {
		return trstimeFrom;
	}

	/**
	 * @param trstimeFrom the trstimeFrom to set
	 */
	public void setTrstimeFrom(String trstimeFrom) {
		this.trstimeFrom = trstimeFrom;
	}

	/**
	 * @return the trstimeTo
	 */
	public String getTrstimeTo() {
		return trstimeTo;
	}

	/**
	 * @param trstimeTo the trstimeTo to set
	 */
	public void setTrstimeTo(String trstimeTo) {
		this.trstimeTo = trstimeTo;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the deleteTrid
	 */
	public String[] getDeleteTrid() {
		return deleteTrid;
	}

	/**
	 * @param deleteTrid the deleteTrid to set
	 */
	public void setDeleteTrid(String[] deleteTrid) {
		this.deleteTrid = deleteTrid;
	}
	
	
}
