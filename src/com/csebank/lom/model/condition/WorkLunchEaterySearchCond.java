/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �����ͳɱ�ͳ�ƽӿ�
 *
 */
public interface WorkLunchEaterySearchCond {
	
	/**
	 * ����
	 */
	public String getEdate();
	
	/**
	 * ��ѯ����
	 */
	public String getSearchtype();
	
	/**
	 * ͳ�Ʋ�ѯʱ�俪ʼ
	 */
	public String getEtime_from();
	
	/**
	 * ͳ�Ʋ�ѯʱ�����
	 */
	public String getEtime_to();

}
