/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ա��ѯform
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1703Form extends BaseForm{


	/** ������ */
	protected String orgsyscoding;
	
	/** ��ɫ���� */
	protected String roletype;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** �û����� */
	protected String username_like;
	
	/** �������� */
	protected String orgname;
	
	/** ��ɫ���� */
	protected String rolename;
	
	/** ���������� */
	protected String pidid;
	
	/** ���˽�ɫ��Ϣ */
	protected String roleid_in;
	
	/**��ѡ��ʶ*/
	protected String single;

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * �������趨
	 * @param orgsyscoding ������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return roletype ��ɫ����
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
	 * ��ɫIDȡ��
	 * @return roleid ��ɫID
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
	 * ��������ȡ��
	 * @return orgname ��������
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
	 * ��ɫ����ȡ��
	 * @return rolename ��ɫ����
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
	 * ����������ȡ��
	 * @return pidid ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���˽�ɫ��Ϣȡ��
	 * @return roleid_in ���˽�ɫ��Ϣ
	 */
	public String getRoleid_in() {
		return roleid_in;
	}

	/**
	 * ���˽�ɫ��Ϣ�趨
	 * @param roleid_in ���˽�ɫ��Ϣ
	 */
	public void setRoleid_in(String roleid_in) {
		this.roleid_in = roleid_in;
	}

	/**
	 * ��дreset����
	 */
	public void reset() {
		this.orgsyscoding = null;
		this.roletype = null;
		this.roleid = null;
		this.orgname = null;
		this.rolename = null;
		this.pidid = null;
		this.roleid_in = null;
	}

	/**
	 * �û�����ȡ��
	 * @return username_like  �û�����
	 */
	public String getUsername_like() {
		return username_like;
	}

	/**
	 * �û������趨
	 * @param username_like  �û�����
	 */
	public void setUsername_like(String username_like) {
		this.username_like = username_like;
	}

	/**
	 * ��ѡ��ʶ  ȡ��
	 * @return single single
	 */
	public String getSingle() {
		return single;
	}

	/**
	 * ��ѡ��ʶ �趨
	 * @param single single
	 */
	public void setSingle(String single) {
		this.single = single;
	}


	
}
