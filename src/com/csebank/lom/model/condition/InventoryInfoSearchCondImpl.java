/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ÿ���̵��ѯ�ӿ�ʵ��
 *
 */
public class InventoryInfoSearchCondImpl implements InventoryInfoSearchCond {
	
	/** ���¿�ʼ */
	protected String date_from;
	
	/** ���½��� */
	protected String date_to;
	
	/** ���¿�ʼ */
	protected String predate_from;
	
	/** ���½��� */
	protected String predate_to;
	
	/** �������� */
	protected String org;
	

	
	/**
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getPredate_from() {
		return predate_from;
	}

	public void setPredate_from(String predate_from) {
		this.predate_from = predate_from;
	}

	public String getPredate_to() {
		return predate_to;
	}

	public void setPredate_to(String predate_to) {
		this.predate_to = predate_to;
	}


}
