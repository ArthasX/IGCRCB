/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG212Info;

/**
  * ����: ����֪ͨ����ʵ��
  * ��������: ����֪ͨ����ʵ��
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG212PK.class)
@Table(name="IG212")
public class IG212TB extends BaseEntity implements Serializable,
		Cloneable, IG212Info {

	/** ״̬ID */
	@Id
	protected String psdid;

	/** �Ƿ�ȷ�� */
	@Id
	protected String psdconfirm;
	
	/** ״̬���� */
	@Transient
	protected String psdname;

	/** �Ƿ��Ͷ��� */
	protected String sms;

	/** �Ƿ����ʼ� */
	protected String email;


	/** ���̶���Id */
	protected String pdid;
	
	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	

	/**
	 * ״̬����ȡ��
	 * 
	 * @return ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ״̬�����趨
	 * 
	 * @param psdname ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * �Ƿ��Ͷ���ȡ��
	 *
	 * @return �Ƿ��Ͷ���
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * �Ƿ��Ͷ����趨
	 *
	 * @param sms �Ƿ��Ͷ���
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * �Ƿ����ʼ�ȡ��
	 *
	 * @return �Ƿ����ʼ�
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * �Ƿ����ʼ��趨
	 *
	 * @param email �Ƿ����ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ���̶���Idȡ��
	 * @return pdid ���̶���Id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���Id�趨
	 * @param pdid ���̶���Id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG212PK(psdid, psdconfirm);
	}

}