/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 *
 */
public interface RecptionAmount{

	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** �Ӵ��������� */
	public String getRname();
	
	/** �Ӵ�������ģ */
	public String getRscale();
	
	/** �Ӵ���׼ */
	public String getRstandard();
	
	/** ״̬��1�����У�2������ */
	public String getRstatus();

	/** �����ܶ� */
	public BigDecimal getAmount();
	
	/** ������������ */
	public String getRapporgname();
	
	/** ��������ID */
	public String getOrgsyscoding();
	
	/** �Ӵ�������ʼ���� */
	public String getRstime();
	
	/** �Ӵ������������� */
	public String getRetime();
	
}
