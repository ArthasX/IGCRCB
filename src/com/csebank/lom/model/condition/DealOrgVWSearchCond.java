/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ˵��������ͲͲ���ͳ�Ʋ�ѯ�ӿ�
 * ���ߣ�������
 */
public interface DealOrgVWSearchCond {
	
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
