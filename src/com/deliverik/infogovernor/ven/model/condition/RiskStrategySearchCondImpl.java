/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * ����: ���ղ��Ա��������ʵ��
  * ��������: ���ղ��Ա��������ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class RiskStrategySearchCondImpl implements
		RiskStrategySearchCond {
	
	/** ���ղ������� */
	protected String rsname;

	/**
	 * ���ղ������ƻ�ȡ
	 * @return
	 */
	public String getRsname() {
		return rsname;
	}

	/**
	 * ���ղ��������趨
	 * @param rsname
	 */
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}
	
	
}