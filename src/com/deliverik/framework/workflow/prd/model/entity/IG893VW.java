/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG893Info;


/**
 * ���̲����߱���Ȩ����ͼʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG893VW implements Serializable, Cloneable,
		IG893Info {
	
	/** ���̱���ID */
	@Id
	protected String pidid;
	
	/** ����״̬��ID */
	protected String psdid;
	
	/** ���̲����߽�ɫID */
	protected Integer roleid;

	/** ���̱������� */
	protected String pidname;
	
	/** ���̱�����ʾ���� */
	protected String pidlabel;
	
	/** ���̱������� */
	protected String piddesc;
	
	/** ���̱������� */
	protected String pidtype;

	/** ���̱���Ȩ�� */
	protected String pidaccess;
	
	protected String pidrequired;

	/**
	 * ����״̬��IDȡ��
	 * @return ����״̬��ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬��ID�趨
	 * @param psdid ����״̬��ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}


	/**
	 * ���̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���̲����߽�ɫID�趨
	 * @param roleid ���̲����߽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return pidid;
	}

	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱���ID�趨
	 * @param pidid ���̱���ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���̱��������趨
	 * @param pidname ���̱�������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ���̱�����ʾ�����趨
	 * @param pidlabel ���̱�����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * ���̱��������趨
	 * @param piddesc ���̱�������
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ���̱��������趨
	 * @param pidtype ���̱�������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���̲����߱���Ȩ��ȡ��
	 * @return ���̲����߱���Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * ���̲����߱���Ȩ���趨
	 * @param pidaccess ���̲����߱���Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	public String getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

}
