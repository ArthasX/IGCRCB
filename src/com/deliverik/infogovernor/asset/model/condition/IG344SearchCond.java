/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: EntityItemRelationDetailVW���������ӿ�
  * ��������: EntityItemRelationDetailVW���������ӿ�
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
public interface IG344SearchCond {

	/**
	 * ��ȡ�����¼��ʼʱ��
	 * @return
	 */
	public String getBeginTime_q();
	
	/**
	 * ��ȡ�����¼����ʱ��
	 * @return
	 */
	public String getEndTime_q();
	
	/**
	 *  �����̱��
	 */
	public String getEiid_q();
	
}