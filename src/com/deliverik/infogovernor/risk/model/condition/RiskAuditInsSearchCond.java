/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * ���������Ϣ��ѯ�����ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditInsSearchCond {
	
	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid();
	
	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid();
	
	/**
	 * ������Ʒ�����ȡ��
	 * @return ������Ʒ�����
	 */
	public String getRaicode();
	
	/**
	 * ������Ʒ��𴴽�����ȡ��
	 * @return ������Ʒ��𴴽�����
	 */
	public String getRaistart();

	/**
	 * ������Ʒ����������ȡ��
	 * @return ������Ʒ����������
	 */
	public String getRaiend();
	
	/**
	 * ������Ʒ���״̬ȡ��
	 * @return ������Ʒ���״̬
	 */
	public String getRaistatus();
}
