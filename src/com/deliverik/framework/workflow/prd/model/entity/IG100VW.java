/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.IG100Info;

/**
 * ���̲����߱���Ȩ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(IG100PK.class)
public class IG100VW implements Serializable, Cloneable, IG100Info {
	
	/** ���̲����߱���Ȩ��ID */
	@Id
	protected String pipdid;
	
	/** ���̱���ID */
	protected String pidid;
	
	/** ���̱�����ʾ���� */
	protected String pidlabel;
	
	/** ���̱���Ȩ�� */
	protected String pidaccess;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/** ���ͣ�0�����趨Ȩ�ޱ���1��δ�趨Ȩ�ޱ��� */
	@Id
	protected String type;
	
	protected String pidrequired;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return new IG100PK(pipdid, type);
	}

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid() {
		return pipdid;
	}

	/**
	 * ���̲����߱���Ȩ��ID�趨
	 * @param pipdid ���̲����߱���Ȩ��ID
	 */
	public void setPipdid(String pipdid) {
		this.pipdid = pipdid;
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
	
	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return ����Ϣ��ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ����Ϣ��ģʽ�趨
	 *
	 * @param pidmode ����Ϣ��ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getType() {
		return type;
	}

	/**
	 * �����趨
	 * 
	 * @param type ����
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	
}
