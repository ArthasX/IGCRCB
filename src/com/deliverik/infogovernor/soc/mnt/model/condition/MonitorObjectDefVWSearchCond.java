/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ��ض���KPI��Ϣ��ͼ���������ӿ�
  * ��������: ��ض���KPI��Ϣ��ͼ���������ӿ�
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefVWSearchCond {

	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName();
	
	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag();
}