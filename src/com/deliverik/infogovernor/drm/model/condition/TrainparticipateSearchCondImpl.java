/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ�����˼�������ʵ��
  * ��������: ��ѵ�����˼�������ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainparticipateSearchCondImpl implements TrainparticipateSearchCond {

	/** ��ѵ��¼ID */
	protected Integer trid;

	/**  
	 * ��ȡ��ѵ��¼ID  
	 * @return trid ��ѵ��¼ID  
	 */
	
	public Integer getTrid() {
		return trid;
	}

	/**  
	 * ������ѵ��¼ID  
	 * @param trid ��ѵ��¼ID  
	 */
	
	public void setTrid(Integer trid) {
		this.trid = trid;
	}
}