/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����������ϵ������������ʵ��
  * ��������: �����������ϵ������������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG482SearchCondImpl implements
		IG482SearchCond {
	
	/** �����鶨��ID */
	protected String pgdid;
	
	/** �ο����̶���ID */
	protected String rpdid;
	
	/** �ο�����״̬ID */
	protected String rpsdid;

	/**
	 * �����鶨��IDȡ��
	 * @return �����鶨��ID
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * �����鶨��ID�趨
	 * @param pgdid �����鶨��ID
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * �ο����̶���IDȡ��
	 * @return �ο����̶���ID
	 */
	public String getRpdid() {
		return rpdid;
	}

	/**
	 * �ο����̶���ID�趨
	 * @param rpdid �ο����̶���ID
	 */
	public void setRpdid(String rpdid) {
		this.rpdid = rpdid;
	}

	/**
	 * �ο�����״̬IDȡ��
	 * @return �ο�����״̬ID
	 */
	public String getRpsdid() {
		return rpsdid;
	}

	/**
	 * �ο�����״̬ID�趨
	 * @param rpsdid �ο�����״̬ID
	 */
	public void setRpsdid(String rpsdid) {
		this.rpsdid = rpsdid;
	}
	
}