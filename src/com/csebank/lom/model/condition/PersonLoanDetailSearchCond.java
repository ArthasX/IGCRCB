/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ��Ա�����ϸ��ѯ�ӿ�
 *
 */
public interface PersonLoanDetailSearchCond {
	
	/**
	 * ����
	 */
	public String getUsername();
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	public String getDate_from();
	
	/**
	 * ��ѯʱ�����
	 */
	public String getDate_to();
	
	public String getGoorgname();
	public String getGoreqorg();
	
}
