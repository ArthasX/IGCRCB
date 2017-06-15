/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG233Info;

/**
  * ����: �Զ������̷��ɶ����ʵ��
  * ��������: �Զ������̷��ɶ����ʵ��
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG233PK.class)
@Table(name="IG233")
public class IG233TB extends BaseEntity implements Serializable,
		Cloneable, IG233Info {

	/** �����ɽڵ����� */
	@Id
	protected String psdid;

	/** ���ɽڵ����� */
	@Id
	protected String assignpsdid;

	/** ���ɰ�ť���� */
	protected String assignpbdid;

	/** �Ƿ������ɱ�ʶ */
	protected String assignflag;

	/**
	 * �����ɽڵ�����ȡ��
	 *
	 * @return �����ɽڵ�����
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * �����ɽڵ������趨
	 *
	 * @param psdid �����ɽڵ�����
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���ɽڵ�����ȡ��
	 *
	 * @return ���ɽڵ�����
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * ���ɽڵ������趨
	 *
	 * @param assignpsdid ���ɽڵ�����
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	/**
	 * ���ɰ�ť����ȡ��
	 *
	 * @return ���ɰ�ť����
	 */
	public String getAssignpbdid() {
		return assignpbdid;
	}

	/**
	 * ���ɰ�ť�����趨
	 *
	 * @param assignpbdid ���ɰ�ť����
	 */
	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	/**
	 * �Ƿ������ɱ�ʶȡ��
	 *
	 * @return �Ƿ������ɱ�ʶ
	 */
	public String getAssignflag() {
		return assignflag;
	}

	/**
	 * �Ƿ������ɱ�ʶ�趨
	 *
	 * @param assignflag �Ƿ������ɱ�ʶ
	 */
	public void setAssignflag(String assignflag) {
		this.assignflag = assignflag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG233PK(psdid, assignpsdid);
	}

}