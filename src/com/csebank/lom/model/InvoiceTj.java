/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.csebank.lom.model;

import java.math.BigDecimal;

/**
 * 
 *  ��Ʊ����ͳ��ʵ��ӿ�
 * 
 * @author piaowei@deliverik.com
 * 
 */
public interface InvoiceTj  {
	/**
	 * ��Ʊͳ�����ȡ��
	 * 
	 * @return ��Ʊͳ�����
	 */
	public String getNum();

	/**
	 * ͳ�Ʒ�Ʊ����ȡ��
	 * 
	 * @return ��Ʊ����
	 */
	public Integer getInvoicenum();
	
	/**
	 * ���벿�Ų����ȡ��
	 * 
	 * @return ���벿�Ų����
	 */
	public String getIreqemp();
	
	/**
	 * ͳ���ܽ��ȡ��
	 * 
	 * @return ͳ���ܽ��
	 */
	public BigDecimal getSumiamount();
	
	/**
	 * ͳ��δ������ȡ��
	 * 
	 * @return ͳ��δ������
	 */
	public BigDecimal getUnsumiamounted();
	
	
	/**
	 * ͳ���Ѹ�����ȡ��
	 * 
	 * @return ͳ���Ѹ�����
	 */
	public BigDecimal getSumiamounted();
	
	/** �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 * */
	public String getEiorgsyscoding();
	
	
	



}