/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

/**
 * ��������δ�����������Ϣ
 */
public class ProcessOverdue implements ProcessOverdueInfo {

	/** ������ID */
	protected String userid;
	
	/** ���������� */
	protected String username;

	/**
	 * ������ID�趨
	 * @return ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������IDȡ��
	 * @param userid ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����������趨
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
