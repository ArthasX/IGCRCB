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
public interface AdvanCescost extends BaseModel {

	/** Ԥ֧����IDȡ�� */
	public Integer getAcid();
	
	/** Ԥ֧���ȡ�� */
	public BigDecimal getAcamount();
	
	/** �ƲƼ�������ȡ�� */
	public String getAcdate();
	
	/** Ԥ֧��ʽȡ�� */
	public String getActype();
	
	/** ֧Ʊ��ȡ�� */
	public String getAcchequenum();
	
	/** Ԥ֧������ȡ�� */
	public String getAcserial();
	
	/** Ԥ֧��Ҫ��;˵��ȡ�� */
	public String getAccomment();
	
	/** Ԥ֧״̬ȡ�� */
	public String getAcstatus();
	
	/** �����ֽ���ȡ�� */
	public BigDecimal getAcfreezeamount();
	
	/** ���Ʊ���ȡ�� */
	public BigDecimal getAcinvoiceamount();
	
	/** �����ȡ�� */
	public BigDecimal getAcstockamount();
	
	/** Ԥ֧�������ȡ�� */
	public String getAccreditdate();
	
	/** �Ǽ���IDȡ�� */
	public String getAcuserid();
	
	/** �Ǽ�������ȡ�� */
	public String getAcusername();
	
	/** Ԥ֧�Ǽ�����ȡ�� */
	public String getAcinsdate();
	
	/** Ԥ֧�Ǽ�ʱ��ȡ�� */
	public String getAcinstime();
	
}
