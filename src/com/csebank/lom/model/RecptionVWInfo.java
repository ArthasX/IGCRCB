/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �Ӵ�ͳ��ʵ��ӿ�
 *
 */
public interface RecptionVWInfo extends BaseModel {

	
	/** �·� */
	public String getMonth();
	
	/** �Ӵ����� */
	public Integer getRnum();
	
	/** �����ܶ� */
	public BigDecimal getAmount();

}
