/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 * Ԥ֧��Աͳ��ʵ��ӿ�
 *
 */
public interface PersonLoanSummary {

	/** �����ȡ�� */
	public String getLpduser();

	/** �����ȡ�� */
	public BigDecimal getLoanamount();
	
	/** ��Ʊ���ȡ�� */
	public BigDecimal getInvoiceamount();
	
	/** �����ֽ�ȡ�� */
	public BigDecimal getPayamount();
	
	public String getLpduserorg();
	
	public OrganizationTB getOrganizationTB();
	
}
