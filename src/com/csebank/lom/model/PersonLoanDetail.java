/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 *��Ա�����ϸͳ��ʵ��ӿ�
 *
 */
public interface PersonLoanDetail {

	/**
	 * IDȡ��
	 * @return ID
	 */
	public String getId();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getDate();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getType();

	/**
	 * ���ȡ��
	 * @return ���
	 */
	public BigDecimal getAmount();

	/**
	 * ��Ʊ���ȡ��
	 * @return ��Ʊ���
	 */
	public BigDecimal getInvoiceamount();
	
	/**
	 * ��;ȡ��
	 * @return ��;
	 */
	public String getComment();

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus();
	
	public String getLpduserorg();
	
	public OrganizationTB getOrganizationTB();
	
}
