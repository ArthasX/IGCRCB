/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ��ɫ��������Ϣ
 */
public class RoleMng implements RoleMngInfo {
	
	/** ��ɫ������ID */
	private String userid;
	
	/** ��ɫ���������� */
	private String username;
	
	/**
	 * ��ɫ������IDȡ��
	 * @return ��ɫ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ɫ����������ȡ��
	 *
	 * @return ��ɫ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ��ɫ������ID�趨
	 *
	 * @param userid ��ɫ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ɫ�����������趨
	 *
	 * @param username ��ɫ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
