/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * �����������Ϣ��ѯ�����ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefSearchCond {
	/**
	 * ������ư汾idȡ��
	 * 
	 * @return ������ư汾id
	 */
	public Integer getRaid();
	
	/**
	 * �����״̬ȡ��
	 * 
	 * @return �����״̬
	 */
	public String getRadstatus();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode();
	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode();
	
	/**
	 * ����������ϼ�������ѯȡ��
	 * @return ����������ϼ�������ѯ
	 */
	public String getRadparcode_q();
	

	/**
	 * ���������汾ȡ��
	 * @return ���������汾
	 */
	public String getRaversion();
	
	/**
	 * ���ղ�ν�������ȡ��
	 * @return ���ղ�ν�������
	 */
	public String getByLevelDesc();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode_q();
}
