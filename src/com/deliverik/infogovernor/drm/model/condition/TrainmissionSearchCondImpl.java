/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ������������ʵ��
  * ��������: ��ѵ������������ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public class TrainmissionSearchCondImpl implements
		TrainmissionSearchCond {
	
	/** ���� */
	protected Integer tpid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * �����趨
	 *
	 * @return tpid ����
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}
	
	

}