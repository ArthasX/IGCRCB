/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵�������ŽӴ����ܲ�ѯ�ӿ�
 * ���ߣ�������
 */
public interface EEOrgVWSearchCond {
	
	/** ��Ȳ�ѯ */
	public String getYear();
	
	/** ��ѯ��ʼ�� */
	public String getMonth_from();
	
	/** ��ѯ������ */
	public String getMonth_to();
	
	/** ���Ų���� */
	public String getRapporgid();
	
	/** ���Ų���� */
	public String getRapporgid_org();

}
