/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ�ƻ�����������ӿ�
  * ��������: ��ѵ�ƻ�����������ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainplanSearchCond {
	
	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getTpusername();
	
	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getTporgname();
	
	/**
	 * �ƻ�����ʱ�俪ʼʱ��ȡ��
	 *
	 * @return �ƻ�����ʱ�俪ʼʱ��
	 */
	public String getStartTimeBegin();
	
	/**
	 * �ƻ�����ʱ�����ʱ��ȡ��
	 *
	 * @return ����ʱ�����ʱ��
	 */
	public String getStartTimeEnd();
	

}