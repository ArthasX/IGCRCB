/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * ���������Ϣ��ѯ�����ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditSearchCond {
	
	/**
	 * ������ư汾idȡ��
	 * 
	 * @return ������ư汾id
	 */
	public Integer getRaid();
	
	/**
	 * ������ư汾ȡ��
	 * 
	 * @return ������ư汾
	 */
	public String getRaversion();
	
	/**
	 * �������״̬ȡ��
	 * 
	 * @return �������״̬
	 */
	public String getRastatus();
	
}
