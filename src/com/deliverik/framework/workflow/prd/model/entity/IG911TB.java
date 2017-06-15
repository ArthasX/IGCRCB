/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG911Info;

/**
  * ����: ״̬�����߹����������Ͷ����ʵ��
  * ��������: ״̬�����߹����������Ͷ����ʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG911")
public class IG911TB extends BaseEntity implements Serializable,
		Cloneable, IG911Info {

	/** ���� */
	@Id
	protected String psprpid;

	/** ���̶���id */
	protected String pdid;

	/** ����״̬id */
	protected String psdid;

	/** �����߽�ɫid */
	protected Integer roleid;

	/** ���������̶���id */
	protected String relevantPdid;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsprpid() {
		return psprpid;
	}

	/**
	 * �����趨
	 *
	 * @param psprpid ����
	 */
	public void setPsprpid(String psprpid) {
		this.psprpid = psprpid;
	}

	/**
	 * ���̶���idȡ��
	 *
	 * @return ���̶���id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���id�趨
	 *
	 * @param pdid ���̶���id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬idȡ��
	 *
	 * @return ����״̬id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬id�趨
	 *
	 * @param psdid ����״̬id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �����߽�ɫidȡ��
	 *
	 * @return �����߽�ɫid
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �����߽�ɫid�趨
	 *
	 * @param roleid �����߽�ɫid
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ���������̶���idȡ��
	 *
	 * @return ���������̶���id
	 */
	public String getRelevantPdid() {
		return relevantPdid;
	}

	/**
	 * ���������̶���id�趨
	 *
	 * @param relevantPdid ���������̶���id
	 */
	public void setRelevantPdid(String relevantPdid) {
		this.relevantPdid = relevantPdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return psprpid;
	}

}