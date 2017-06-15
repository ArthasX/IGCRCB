package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * �û���Ϣ��������ʵ��
 * 
 */
public class UserSearchCondImpl implements UserSearchCond {

	/** �û�ID */
	protected String userid;
	
	/** �û�ID */
	protected String userid_q;
	
	/** �û����� */
	protected String username;
	
	/** �û����� */
	protected String username_q;

	/** �û����� */
	protected String password;
	
	/** �û���������� */
	protected String orgid;
	
	/** �û���������� */
	protected String orgid_like;
	
	/** �û��ֻ� */
	protected String usermobile;

	/** �߼�ɾ����־λ */
	protected String deleteflag;
	
	/** ���� */
	protected String userinfo;
	
	/** ���� */
	protected String userinfo_like;
	
	/** �û�ID��Χ */
	protected List<String> userid_in;

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
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
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid_q �û�ID
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
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
	public String getUsername_q() {
		return username_q;
	}

	/**
	 * �û������趨
	 *
	 * @param username_q �û�����
	 */
	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * �û������趨
	 *
	 * @param password �û�����
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgid �û����������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgid_like() {
		return orgid_like;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgid �û����������
	 */
	public void setOrgid_like(String orgid_like) {
		this.orgid_like = orgid_like;
	}

	/**
	 * �û��ֻ�ȡ��
	 * @return �û��ֻ�
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * �û��ֻ��趨
	 *
	 * @param usermobile �û��ֻ�
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	
	/**
	 * �߼�ɾ����־λȡ��
	 * @return �߼�ɾ����־λ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����־λ�趨
	 *
	 * @param deleteflag �߼�ɾ����־λ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo() {
		return userinfo;
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
	 * ����ȡ��
	 * @return ����
	 */
	public String getUserinfo_like() {
		return userinfo_like;
	}
	
	/**
	 * �����趨
	 *
	 * @param userinfo_like ���� 
	 */
	public void setUserinfo_like(String userinfo_like) {
		this.userinfo_like = userinfo_like;
	}
	
	/**
	 * �û�ID��Χȡ��
	 * @return userid_in �û�ID��Χ
	 */
	public List<String> getUserid_in() {
		return userid_in;
	}

	/**
	 * �û�ID��Χ�趨
	 * @param userid_in �û�ID��Χ
	 */
	public void setUserid_in(List<String> userid_in) {
		this.userid_in = userid_in;
	}
}
