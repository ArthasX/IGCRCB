/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * �û���Ϣ
 */
public class User implements UserInfo {
	
	/** ������������� */
	private String orgid;

	/** ������������ */
	private String orgname;

	/** �û�ID */
	private String userid;

	/** ���� */
	private String userinfo;

	/** �ֻ��� */
	private String usermobile;

	/** �û����� */
	private String username;
	
	/** �û����� */
	private String useremail;
	
	/**
	 * �������������ȡ��
	 *
	 * @return �������������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	
	public String getOrgname() {
		return orgname;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * �ֻ���ȡ��
	 *
	 * @return �ֻ���
	 */
	public String getUsermobile() {
		return usermobile;
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
	 * ��������������趨
	 *
	 * @param orgid �������������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * �������������趨
	 *
	 * @param orgname ������������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * �����趨
	 *
	 * @param userinfo ����
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * �ֻ����趨
	 *
	 * @param usermobile �ֻ���
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
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
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * �û������趨
	 * @param useremail �û�����
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

}