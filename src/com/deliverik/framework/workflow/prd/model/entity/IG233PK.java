/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �Զ������̷��ɶ����ʵ������
  * ��������: �Զ������̷��ɶ����ʵ������
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG233PK extends BasePK implements Serializable {

	/** �����ɽڵ����� */
	protected String psdid;

	/** ���ɽڵ����� */
	protected String assignpsdid;

	/**
	 * ���캯��
	 */
	public IG233PK() {

	}

	/**
	 * ���캯��
	 */
	public IG233PK(String psdid, String assignpsdid) {
		super();
		this.psdid = psdid;
		this.assignpsdid = assignpsdid;
	}

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

}