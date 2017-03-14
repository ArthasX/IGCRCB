/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG931Info;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����ʵ��
  * ��������: ȱʡ״̬�����߹����������Ͷ����ʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG931")
public class IG931TB extends BaseEntity implements Serializable,
		Cloneable, IG931Info {

	/** ���� */
	@Id
	protected String dpsprpid;

	/** ���̶���id */
	protected String pdid;

	/** ����״̬id */
	protected String psdid;

	/** ���������̶���id */
	protected String relevantPdid;
    
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDpsprpid() {
		return dpsprpid;
	}

	/**
	 * �����趨
	 *
	 * @param dpsprpid ����
	 */
	public void setDpsprpid(String dpsprpid) {
		this.dpsprpid = dpsprpid;
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
		return dpsprpid;
	}
}