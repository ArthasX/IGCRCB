package com.csebank.lom.model.condition;

public interface InvoiceInfoSearchCond {
	
	/**
	 * ��Ʊ����
	 */
	public String getItype();
	
	/**
	 * ��Ʊ��ѯʱ�俪ʼ
	 */
	public String getIdate_from();
	
	/**
	 * ��Ʊ��ѯʱ�����
	 */
	public String getIdate_to();
	
	/**
	 * ���벿�Ų����
	 */
	public String getIreqemp();
	
	/**
	 * ������ID
	 */
	public String getIrequser();
	
	/**
	 * ��Ʊ���
	 */
	public String getIamount();
	
	/**
	 * ״̬
	 */
	public String getIstatus();
	
	/**
	 * ����ͳ��
	 */
	public String getIyear();
	
	/**  */
	public String getIreqempid();
	
	/** ���������� */
	public String getIrequsername();
	
	/** �ʲ����������� */
	public String getEiorgsyscoding();

}
