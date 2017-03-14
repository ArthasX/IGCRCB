/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG334Info;

/**
  * ����: ֪ͨ���Ի�����Ϣʵ��
  * ��������: ֪ͨ���Ի�����Ϣʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG334")
public class IG334TB extends BaseEntity implements Serializable,
		Cloneable, IG334Info {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ����֪ͨ */
	protected String sms;

	/** ֪ͨ�ʼ� */
	protected String email;

	/** ������ID */
	protected String pidid;
	
	/** ���������� */
	protected String pidname;

	/** �� */
	protected Integer notifyd;

	/** Сʱ */
	protected Integer notifyh;

	/** �� */
	protected Integer notifym;

	/** ��ɫID */
	protected Integer roleid;

	/** ����BL */
	protected String processbl;
	
	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����֪ͨȡ��
	 *
	 * @return ����֪ͨ
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * ����֪ͨ�趨
	 *
	 * @param sms ����֪ͨ
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * ֪ͨ�ʼ�ȡ��
	 *
	 * @return ֪ͨ�ʼ�
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ֪ͨ�ʼ��趨
	 *
	 * @param email ֪ͨ�ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ������IDȡ��
	 * @return pidid ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����������ȡ��
	 * @return pidname ����������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �����������趨
	 * @param pidname ����������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ��ȡ��
	 * @return notifyd ��
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * ���趨
	 * @param notifyd ��
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * Сʱȡ��
	 * @return notifyh Сʱ
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * Сʱ�趨
	 * @param notifyh Сʱ
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * ��ȡ��
	 * @return notifym ��
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * ���趨
	 * @param notifym ��
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
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
	 * ����BLȡ��
	 * @return processbl ����BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * ����BL�趨
	 * @param processbl ����BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pdid;
	}

}