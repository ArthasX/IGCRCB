/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ��ɫ��Ϣ
 */
public class Role implements RoleInfo {
	
	/** ��ɫID */
	private Integer roleid;

	/** ��ɫ���� */
	private String rolename;

	/** ��ɫ���� */
	private String roletype;

	/** ��������Χ */
	private String roledomain;

	/** �ʲ��������� */
	private String assetdomain;

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
	 * @param roletype ��ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * ��������Χȡ��
	 * @return ��������Χ
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * ��������Χ�趨
	 * @param roledomain ��������Χ
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * �ʲ����������趨
	 * @param assetdomain �ʲ���������
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}
	
}