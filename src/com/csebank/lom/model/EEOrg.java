/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ˵�������ŽӴ�ͳ�ƽӿ�
 * ���ߣ�������
 */
public interface EEOrg {
	
	/** �Ӵ����� */
	public Integer getRnum();
	
	/** �����ܶ� */
	public BigDecimal getAmount();
	
	/** ��Ҫ���벿�Ų���� */
	public String getRapporgid();

	/** ���� */
	public String getRapporgname();
	
	
	
}
