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
public interface DealAmount{

	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** ״̬��1�����У�2������ */
	public String getRstatus();

	/** �����ܶ� */
	public BigDecimal getAmount();
	
	public String getRapporgname();
	
	public String getOrgsyscoding();
	
}
