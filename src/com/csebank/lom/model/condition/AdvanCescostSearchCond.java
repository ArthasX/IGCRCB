/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * Ԥ֧���ò�ѯ�ӿ�
 *
 */
public interface AdvanCescostSearchCond {
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	public String getAcdate_from();
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	public String getAcdate_to();
	
	/**
	 * Ԥ֧����״̬ȡ��
	 * @return Ԥ֧����״̬
	 */
	public String getAcstatus_q();
	
}
