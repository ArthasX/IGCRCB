/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * ����: ��־��Ϣ���������ӿ�
  * ��������: ��־��Ϣ���������ӿ�
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public interface RealtimedetailSearchCond {
	
	/**
	 * ����ID
	 * @return
	 */
	public Integer getTaskid();
	/**
	 * ����IP
	 * @return
	 */
	public String getHostip();
	/**
	 * ��������
	 * @return
	 */
	public Integer getRtdid_gt();

}