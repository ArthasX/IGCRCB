package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * �û���ɫ��Ȩ��Ϣ��������ʵ��
 * 
 */
public class UserRoleVWSearchCondImpl implements UserRoleVWSearchCond {

	/** �û�ID */
	protected String userid;
	
	/** �û���ɫID */
	protected Integer roleid;
	
	/** �û���ɫ���� */
	protected String roletype;
	
	/** �û���ɫ���� */
	protected String roles_Like;
	
	/** ��չ��ɫ���� */
	protected String[] roles_BP_EX;
	
	/** �Ƿ��ɫ������ */
	protected boolean rolemanager;
	
	/** �Ƿ��ɫֵ���� */
	protected boolean dutyflag;
	
	/** ��ɫ�������� */
	public String assetdomain;
	
	/** ��ɫ��������Χ */
	protected String roledomain_like;
	
	/** ��ɫ��������Χ */
	protected String roledomain;
	
	/** ����syscoding���ģ����ѯ */
	protected String orgid_like;
	
	/** ��ɫ��Χ */
	protected List<Integer> roleid_in;
	
	/** ����ɫ�û���ȨID��ѯ */
	protected Integer urid_eq;
	
	/** ����ɫ����ģ����ѯ */
	protected String rolename_like;

	/** �û��� */
	protected String username_like;
	
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
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleid �û���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * �û���ɫ�����趨
	 *
	 * @param roles_Like �û���ɫ����
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * ��չ�û���ɫ����ȡ��
	 * @return ��չ�û���ɫ����
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * ��չ�û���ɫ�����趨
	 *
	 * @param roles_BP_EX ��չ�û���ɫ����
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * ��ɫ������ȡ��
	 * @return ��ɫ������
	 */
	public boolean isRolemanager() {
		return rolemanager;
	}

	/**
	 * ��ɫ�������趨
	 *
	 * @param rolemanager ��ɫ������
	 */
	public void setRolemanager(boolean rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * ��ɫֵ����ȡ��
	 * @return ��ɫֵ����
	 */
	public boolean isDutyflag() {
		return dutyflag;
	}

	/**
	 * ��ɫֵ�����趨
	 *
	 * @param dutyflag ��ɫֵ����
	 */
	public void setDutyflag(boolean dutyflag) {
		this.dutyflag = dutyflag;
	}

	/**
	 * ��ɫ��������ȡ��
	 * 
	 * @return ��ɫ��������
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * ��ɫ���������趨
	 * 
	 * @param assetdomain ��ɫ��������
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * ��ɫ��������Χȡ��
	 * 
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_like() {
		return roledomain_like;
	}

	/**
	 * ��ɫ��������Χ�趨
	 * 
	 * @param roledomain_like ��ɫ��������Χ
	 */
	public void setRoledomain_like(String roledomain_like) {
		this.roledomain_like = roledomain_like;
	}
	
	/**
	 * ��ɫ��������Χȡ��
	 * 
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * ��ɫ��������Χ�趨
	 * 
	 * @param roledomain ��ɫ��������Χ
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * ����syscoding���ģ����ѯȡ��
	 *
	 * @return orgid_like ����syscoding���ģ����ѯ
	 */
	public String getOrgid_like() {
		return orgid_like;
	}

	/**
	 * ����syscoding���ģ����ѯ�趨
	 *
	 * @param orgid_like ����syscoding���ģ����ѯ
	 */
	public void setOrgid_like(String orgid_like) {
		this.orgid_like = orgid_like;
	}
	
	/**
	 * ��ɫ��Χȡ��
	 *
	 * @return roleid_in ��ɫ��Χ
	 */
	public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	/**
	 * ��ɫ��Χ�趨
	 *
	 * @param roleid_in ��ɫ��Χ
	 */
	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}
	
	/**
	 * ����ɫ����ģ����ѯȡ��
	 *
	 * @return rolename_like ����ɫ����ģ����ѯ
	 */
	public String getRolename_like() {
		return rolename_like;
	}
	
	/**
	 * ����ɫ�û���ȨID��ѯȡ��
	 *
	 * @return urid_eq ����ɫ�û���ȨID��ѯ
	 */
	public Integer getUrid_eq() {
		return urid_eq;
	}

	/**
	 * ����ɫ�û���ȨID��ѯ�趨
	 *
	 * @param urid ����ɫ�û���ȨID��ѯ
	 */
	public void setUrid_eq(Integer urid_eq) {
		this.urid_eq = urid_eq;
	}

	/**
	 * ����ɫ����ģ����ѯ�趨
	 *
	 * @param rolename_like ����ɫ����ģ����ѯ
	 */
	public void setRolename_like(String rolename_like) {
		this.rolename_like = rolename_like;
	}
	
	/**
	 * �û���ȡ��
	 * @return username_like �û���
	 */
	public String getUsername_like() {
		return username_like;
	}

	/**
	 * �û����趨
	 * @param username_like �û���
	 */
	public void setUsername_like(String username_like) {
		this.username_like = username_like;
	}
	
}
