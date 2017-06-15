/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * 
 * Ԥ֧��ϸͳ��ʵ��ӿ�
 *
 */
public interface AdvanceDetail {
	
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
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getTime();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getType();

	/**
	 * ��Աȡ��
	 * @return ��Ա
	 */
	public String getUsername();

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
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getStockamount();

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus();
	
}
