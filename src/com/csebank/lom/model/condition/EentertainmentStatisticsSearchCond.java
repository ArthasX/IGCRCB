/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ���д�����ͳ�ƽӿ�
 *
 */
public interface EentertainmentStatisticsSearchCond {
	
	/**
	 * ʳ���д�����ͳ�Ʋ�ѯʱ�俪ʼ
	 */
	public String getEtime_from();
	
	/**
	 * ʳ���д�����ͳ�Ʋ�ѯʱ�����
	 */
	public String getEtime_to();
	
	/**
	 * ��ѯ����
	 * @return ��ѯ����
	 */
	public String getEwhere();

}
