/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: EntityItemRelationVW���������ӿ�
  * ��������: EntityItemRelationVW���������ӿ�
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public interface IG343SearchCond {

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
	 * ��ȡ�����¼�ķ���������
	 * @return
	 */
	public String getEiname_like();
}