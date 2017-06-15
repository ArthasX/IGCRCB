/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG123Info;

/**
  * ����: �Զ������̻�����Χ��ʵ��
  * ��������: �Զ������̻�����Χ��ʵ��
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG123")
public class IG123TB extends BaseEntity implements Serializable,
		Cloneable, IG123Info {

	/** ���� */
	@Id
	protected String potdid;

	/** ������������ */
	protected String pdid;

	/** ������ */
	protected String orgid;

	/** �������� */
	protected String orgname;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPotdid() {
		return potdid;
	}

	/**
	 * �����趨
	 *
	 * @param potdid ����
	 */
	public void setPotdid(String potdid) {
		this.potdid = potdid;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������������趨
	 *
	 * @param pdid ������������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 *
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return potdid;
	}

}