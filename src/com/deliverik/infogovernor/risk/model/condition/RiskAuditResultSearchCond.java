/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * ����������������Ϣ��ѯ�����ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditResultSearchCond {
	
	/**
	 * ��������������IDȡ��
	 * @return ��������������ID
	 */
	public Integer getRarid();
	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid();
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid();
	/**
	 * �������������IDȡ��
	 * @return �������������ID
	 */
	public String getRaruserid();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode();
}
