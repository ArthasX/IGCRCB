/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;



/**
  * ����: �����������ϵʵ�����������ʵ��
  * ��������: �����������ϵʵ�����������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG485SearchCondImpl implements
		IG485SearchCond {

	/** �ο�����ʵ��ID */
	protected Integer prid;

	/** ״̬ */
	protected String pgrrstatus;

	/**
	 * �ο�����ʵ��IDȡ��
	 * @return �ο�����ʵ��ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �ο�����ʵ��ID�趨
	 * @param prid �ο�����ʵ��ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getPgrrstatus() {
		return pgrrstatus;
	}

	/**
	 * ״̬�趨
	 * @param pgrrstatus ״̬
	 */
	public void setPgrrstatus(String pgrrstatus) {
		this.pgrrstatus = pgrrstatus;
	}
	
}