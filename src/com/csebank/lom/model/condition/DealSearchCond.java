/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �Ӵ���ѯ�ӿ�
 *
 */
public interface DealSearchCond {
	
	/**
	 * �Ӵ�����
	 */
	public Integer getRid();
	public String getDeptName();
	
	/**
	 * �Ӵ�״̬
	 */
	public String getRstatus();
	
	/**
	 * ʱ��
	 */
	public String getDealTime();
	

	/**
	 * ���벿�Ų����
	 */
	public String getRapporgid();
	
	/**
	 * ͳ�����
	 */
	public String getYear();
	
	/**
	 * ͳ���·�
	 */
	public String getMonth();
	
	/**
	 * ���ŽӴ�ͳ�����벿�Ų����
	 */
	public String getRapporgid_org();
	
	/**
	 * ���ŽӴ�ͳ�����
	 */
	public String getYear_org();
	
	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	public String getMonth_from_org();
	
	/**
	 * ���ŽӴ�ͳ�ƽ����·�
	 */
	public String getMonth_to_org();
	
	/**
	 * �Ӵ���ѯʱ�俪ʼ
	 */
	public String getRtime_from();
	
	/**
	 * �Ӵ���ѯʱ�����
	 */
	public String getRtime_to();
}
