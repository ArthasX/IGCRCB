package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * ��ɫ��Ϣ��������ʵ��
 * 
 */
public class RoleSearchCondImpl implements RoleSearchCond {

	/** ��ɫ���� */
	protected String rolename;
	
	/** ��ɫ���� */
	protected String rolename_q;

	/** ��ɫ����*/
	protected String roletype;

	/** ��ɫ���� */
	protected String roles_Like;

	/** ��չ��ɫ���� */
	protected String[] roles_BP_EX;
	
	/** SQL���ȽϹ�ϵ */
	protected int roletypeEqual;

	/** ��ɫ��������Χ */
	protected String roledomain;

	/** ��ɫ��������Χ */
	protected String roledomain_Like;

	/** ��ɫ�ʲ�����Χ */
	protected String assetdomain;

	/** ��ɫ�ʲ�����Χ */
	protected String assetdomain_q;
	
	/** ��ɫ���Ͳ�ѯ��������ɫ���ʹ��ڣ�*/
	protected String roletype_gt;
	
	/** �Զ�������ID */
	protected String pdid;
	
	/** ��ɫID��Χ */
	protected List<Integer> roleid_in;
	
	/** ��ɫID���ڴ˷�Χ */
	protected String roleid_not_in;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ɫ���Ͳ�ѯ����ȡ��
	 * @return ��ɫ���Ͳ�ѯ����
	 */
	public String getRoletype_gt() {
		return roletype_gt;
	}

	/**
	 * ��ɫ���Ͳ�ѯ�����趨
	 *
	 * @param roletype_gt ��ɫ���Ͳ�ѯ����
	 */
	public void setRoletype_gt(String roletype_gt) {
		this.roletype_gt = roletype_gt;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
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
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename_q() {
		return rolename_q;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param rolename_q ��ɫ����
	 */
	public void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param roletype ��ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param roles_Like ��ɫ����
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * ��չ��ɫ����ȡ��
	 * @return ��չ��ɫ����
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * ��չ��ɫ�����趨
	 *
	 * @param roles_BP_EX ��չ��ɫ����
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * SQL���ȽϹ�ϵȡ��
	 * @return SQL���ȽϹ�ϵ
	 */
	public int getRoletypeEqual() {
		return roletypeEqual;
	}

	/**
	 * SQL���ȽϹ�ϵ�趨
	 *
	 * @param roletypeEqual SQL���ȽϹ�ϵ
	 */
	public void setRoletypeEqual(int roletypeEqual) {
		this.roletypeEqual = roletypeEqual;
	}

	/**
	 * ��ɫ��������Χȡ��
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
	 * ��ɫ��������Χȡ��
	 * @return ��ɫ��������Χ
	 */
	public String getRoledomain_Like() {
		return roledomain_Like;
	}

	/**
	 * ��ɫ��������Χ�趨
	 *
	 * @param roledomain_Like ��ɫ��������Χ
	 */
	public void setRoledomain_Like(String roledomain_Like) {
		this.roledomain_Like = roledomain_Like;
	}

	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * ��ɫ�ʲ�����Χ�趨
	 *
	 * @param assetdomain ��ɫ�ʲ�����Χ
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * ��ɫ�ʲ�����Χȡ��
	 * @return ��ɫ�ʲ�����Χ
	 */
	public String getAssetdomain_q() {
		return assetdomain_q;
	}

	/**
	 * ��ɫ�ʲ�����Χ�趨
	 *
	 * @param assetdomain_q ��ɫ�ʲ�����Χ
	 */
	public void setAssetdomain_q(String assetdomain_q) {
		this.assetdomain_q = assetdomain_q;
	}
	
	/**
	 * ��ɫID��Χȡ��
	 * @return roleid_in ��ɫID��Χ
	 */
	public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	/**
	 * ��ɫID��Χ�趨
	 * @param roleid_in ��ɫID��Χ
	 */
	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}
	
	/**
	 * ��ɫID���ڴ˷�Χȡ��
	 * @return ��ɫID���ڴ˷�Χ
	 */
	public String getRoleid_not_in() {
		return roleid_not_in;
	}

	/**
	 * ��ɫID���ڴ˷�Χ�趨
	 * @param roleid_not_in ��ɫID���ڴ˷�Χ
	 */
	public void setRoleid_not_in(String roleid_not_in) {
		this.roleid_not_in = roleid_not_in;
	}
}
