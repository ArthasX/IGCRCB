/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * ����: ����ִ������Ϣʵ��
 * ��������: ����ִ������Ϣʵ��
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG602PK.class)
public class IG602VW implements Serializable,
	Cloneable, IG602Info {
	
	/** �û�ID */
	@Id
	protected String userid;
	
	/** �û����� */
	protected String username;

	/** �û���ɫID */
	@Id
	protected Integer roleid;

	/** �û���ɫ���� */
	protected String rolename;
	
	/** �û���������� */
	protected String orgsyscoding;

	/** �û��������� */
	protected String orgname;
	
	/** ������ɱ�ʶ��0δָ����1δ����2�Ѵ��� */
	protected String doneFlag;

	/** �û��ֻ��� */
	protected String usermobile;
	
	/** �û����� */
	protected String userinfo;
	
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
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * �û�����������趨
	 *
	 * @param orgname �û����������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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
	 * ������ɱ�ʶȡ��
	 * 
	 * @return ������ɱ�ʶ
	 */
	public String getDoneFlag() {
		return doneFlag;
	}

	/**
	 * ������ɱ�ʶ�趨
	 * 
	 * @param doneFlag ������ɱ�ʶ
	 */
	public void setDoneFlag(String doneFlag) {
		this.doneFlag = doneFlag;
	}

	/**
	 * �û��ֻ���ȡ��
	 * 
	 * @return �û��ֻ���
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * �û��ֻ����趨
	 * 
	 * @param usermobile �û��ֻ���
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * �û�����ȡ��
	 * 
	 * @return �û�����
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * �û������趨
	 * 
	 * @param userinfo �û�����
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
}
