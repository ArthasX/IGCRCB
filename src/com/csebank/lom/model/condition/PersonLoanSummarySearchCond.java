/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�
 *
 */
public interface PersonLoanSummarySearchCond {
	
	/**
	 * ������������������
	 */
	public String getLpduserorg();
	
	/**
	 * ����ѯʱ�俪ʼ
	 */
	public String getLpddate_from();
	
	/**
	 * ����ѯʱ�����
	 */
	public String getLpddate_to();
	
}
