/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ�ù����ŽӴ����ܲ�ѯ�ӿ�
 * ���ߣ�������
 */
public interface EESearchCond {
	
	
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
