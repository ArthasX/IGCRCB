/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �Ӵ���ѯ�ӿ�
 *
 */
public interface RecptionSearchCond {
	
	/**
	 * �Ӵ�����
	 */
	public Integer getRid();
	
	/**
	 * �Ӵ�״̬
	 */
	public String getRstatus_q();
	
	/**
	 * �Ӵ���ѯ��ʼʱ�俪ʼ
	 */
	public String getRtime_from();
	
	/**
	 * �Ӵ���ѯ��ʼʱ�����
	 */
	public String getRtime_to();
	
	/**
	 * �Ӵ���ѯ����ʱ�俪ʼ
	 */
	public String getRetime_from();
	
	/**
	 * �Ӵ���ѯ����ʱ�����
	 */
	public String getRetime_to();
	
	/**
	 * ���벿�Ų����
	 */
	public String getRapporgid_q();
	
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
	

}
