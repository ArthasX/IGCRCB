/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ�ó�����ϸ��ѯ�ӿ�
 * ���ߣ�������
 */
public interface GoutDetailSearchCond {
	
	/** ��ѯ��ʼ�� */
	public String getMonth_from();
	/** ��ѯ������ */
	public String getMonth_to();
	/** ��ѯ�� */
	public String getYear();
	/** ʹ����������ͨ���Ļ����д����� */
	public String getUseType();
	/** ������ */
	public String getGuser();
}
