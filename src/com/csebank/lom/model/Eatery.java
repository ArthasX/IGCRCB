/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 *
 */
public interface Eatery extends BaseModel {

	/** �������������� */
	public Integer getEid();
	
	/** ���� */
	public String getEdate();
	
	/** �ɹ�ԭ�ϳɱ� */
	public BigDecimal getEstaplecost();
	
	/** ��ζƷ�ɱ� */
	public BigDecimal getEflavouringcost();
	
	/** �����ɱ� */
	public BigDecimal getEothercost();

}
