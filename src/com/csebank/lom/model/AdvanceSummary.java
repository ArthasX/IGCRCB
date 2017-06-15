/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * Ԥ֧����ʵ��ӿ�
 * 
 */
public interface AdvanceSummary extends BaseModel {

	/** ���ȡ�� */
	public String getAsyear();

	/** �·�ȡ�� */
	public String getAsmonth();

	/** �������ȡ�� */
	public BigDecimal getAsprebalance();

	/** ����Ԥ֧���ȡ�� */
	public BigDecimal getAsadvancescost();

	/** �����ȡ�� */
	public BigDecimal getAsloan();

	/** ���·�Ʊ���ȡ�� */
	public BigDecimal getAsinvoice();

	/** ���»�����ȡ�� */
	public BigDecimal getAspay();

	/** �������ȡ�� */
	public BigDecimal getAsbalance();

	/** ������ȡ�� */
	public BigDecimal getAsfreeze();

}
