/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ��Ա�����ϸ��ѯ�ӿ�ʵ��
 *
 */
public class PersonLoanDetailSearchCondImpl implements PersonLoanDetailSearchCond {
	
	/**
	 * ����
	 */
	protected String username;
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	protected String date_from;
	
	/**
	 * ��ѯʱ�����
	 */
	protected String date_to;
	
	protected String goorgname;
	protected String goreqorg;
	
	/**
	 * �����趨
	 * @return ����
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * �����趨
	 * @param username ����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @return ��ѯʱ�俪ʼ
	 */
	public String getDate_from() {
		return date_from;
	}

	/**
	 * ��ѯʱ�俪ʼ�趨
	 * @param date_from ��ѯʱ�俪ʼ
	 */
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	/**
	 * ��ѯʱ������趨
	 * @return ��ѯʱ�����
	 */
	public String getDate_to() {
		return date_to;
	}

	/**
	 * ��ѯʱ������趨
	 * @param date_to ��ѯʱ�����
	 */
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getGoorgname() {
		return goorgname;
	}

	public void setGoorgname(String goorgname) {
		this.goorgname = goorgname;
	}

	public String getGoreqorg() {
		return goreqorg;
	}

	public void setGoreqorg(String goreqorg) {
		this.goreqorg = goreqorg;
	}
}