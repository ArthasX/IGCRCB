package com.deliverik.framework.user.model.condition;

/**
 * �û���ɫ������Ϣ��������ʵ��
 * 
 */
public class UserInfoSearchCondImpl implements UserInfoSearchCond {

	/** �û�ID */
	protected String userida;
	
	/** �û����� */
	protected String username;
	
	/** �û���ɫID */
	protected Integer roleida;

	/** �û���ɫ���� */
	protected String rolename;
	
	/** �û���ɫ���� */
	protected String roletype;
	
	/** �û���������� */
	protected String orgida;

	/** �û��������� */
	protected String orgname;
	
	/** ���� */
	protected String userinfo;
	
	/** ���� */
	protected String userinfo_like;
	
	/** �û����� ��PMSϵͳ�Խ�ר��*/
	protected String username_forPms;
	
	
	
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserida() {
		return userida;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userida �û�ID
	 */
	public void setUserida(String userida) {
		this.userida = userida;
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
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleida() {
		return roleida;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleid �û���ɫID
	 */
	public void setRoleida(Integer roleida) {
		this.roleida = roleida;
	}

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �û���ɫ�����趨
	 *
	 * @param rolename �û���ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	/**
	 * �û����������ȡ��
	 * @return �û����������
	 */
	public String getOrgida() {
		return orgida;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgida �û����������
	 */
	public void setOrgida(String orgida) {
		this.orgida = orgida;
	}

	/**
	 * �û���������ȡ��
	 * @return �û���������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * �û����������趨
	 *
	 * @param orgname �û���������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * �û���ɫ�����趨
	 *
	 * @param roletype �û���ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
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
	 * �û����ƣ�PMSϵͳ�Խ�ר��ȡ��
	 * @return username_forPms �û����ƣ�PMSϵͳ�Խ�ר��
	 */
	
	public String getUsername_forPms() {
		return username_forPms;
	}

	/**
	 * �û����ƣ�PMSϵͳ�Խ�ר���趨
	 * @param username_forPms �û����ƣ�PMSϵͳ�Խ�ר��
	 */
	public void setUsername_forPms(String username_forPms) {
		this.username_forPms = username_forPms;
	}
	
}
