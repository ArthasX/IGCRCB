/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

import java.io.Serializable;
/**
  * ����: �����ⲿ���ö�����������ʵ��
  * ��������: �����ⲿ���ö�����������ʵ��
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
public class IG992SearchCondImpl implements
IG992SearchCond {

	/** ���� */
	protected Integer pedid;

	/** �ⲿ�¼�ID */
	protected String pedeventid;

	/** �ⲿ���� */
	protected String pedaction;

	/** �ⲿ���� */
	protected String peddesc;


	public Integer getPedid() {
		return pedid;
	}

	public void setPedid(Integer pedid) {
		this.pedid = pedid;
	}

	/**
	 * �ⲿ�¼�ȡ��
	 *
	 * @return �ⲿ�¼�
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �ⲿ�¼��趨
	 *
	 * @param pedeventid�ⲿ�¼�
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * �ⲿ����ȡ��
	 *
	 * @return �ⲿ����
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * �ⲿ�����趨
	 *
	 * @param pdid �ⲿ����
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * �ⲿ����ȡ��
	 *
	 * @return �ⲿ����
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * �ⲿ�����趨
	 *
	 * @param psdid �ⲿ����
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pedid;
	}
}