/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ����ͳ�Ʋ�ѯ�ӿ�
 *
 */
public interface RecptionOrgVWSearchCond {
	
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
