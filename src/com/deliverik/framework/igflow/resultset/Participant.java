/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̲�������Ϣ
 */
public class Participant implements ParticipantInfo {
	
	/** ��������� */
	private String orgid;

	/** �������� */
	private String orgname;

	/** ��ɫID */
	private Integer roleid;

	/** ��ɫ���� */
	private String rolename;
	
	/** �û�ID */
	private String userid;
	
	/** �û����� */
	private String username;
	
	/** �ֻ��� */
	private String phone;
	
	/** ����ʼʱ�� */
	private String ppinittime; 
	
	/** �������ʱ�� */
	private String ppproctime;
	
	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����������趨
	 * @param orgid ���������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �û������趨
	 *
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * �ֻ���ȡ��
	 * @return �ֻ���
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * �ֻ����趨
	 * @param phone �ֻ���
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * ����ʼʱ��ȡ��
	 * @return ����ʼʱ��
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * ����ʼʱ���趨 
	 * @return ����ʼʱ��
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * �������ʱ��ȡ��
	 * @param ppopentime �������ʱ�� 
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * �������ʱ���趨
	 * @param ppproctime �������ʱ��
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}
}