/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: EntityItemAndConfigItemVW��������ʵ��
  * ��������: EntityItemAndConfigItemVW��������ʵ��
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public class IG342SearchCondImpl implements
		IG342SearchCond {

	/** �����̵Ǽǿ�ʼʱ�� */
	protected String beginTime_q;
	
	/** �����̵Ǽǽ���ʱ�� */
	protected String endTime_q;

	/**
	 * ��ȡbeginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * ����beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * ��ȡendTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * ����endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	
	
}