/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �軹����ϸ��ѯ�ӿ�
 *
 */
public interface LoanPayDetailSearchCond {
	
	/** �����ȡ�� */
	public String getLpduser_q();
	
	/** ��Ʊ���ڿ�ʼȡ�� */
	public String getLpdinvoicedate_from();
	
	/** ��Ʊ���ڽ���ȡ�� */
	public String getLpdinvoicedate_to();
	
	/** �������ȡ�� */
	public String getLpdtype_q();
	
	/** ��Ʊ���ȡ�� */
	public String getLpdinvoiceamount_q();
	
	/** ״̬ȡ�� */
	public String getLpdstatus_q();
	
	/** �Ӵ�ID */
	public Integer getRid_q();
	
	/** ��Ʊ���ID */
	public Integer getLdid_invoice();
	
	/**����ѯ��ʼʱ�� */
	public String getTime_from();
	/**����ѯ����ʱ�� */
	public String getTime_to();
	/**�������״̬ */
	public String getSpType();
	
}
