/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * ���̹�ϵ��ѯ�����ӿ�
 * 
 */
public interface EmergencyRelationSearchCond {

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid();

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid();
	/**
	 * ������ϵ
	 * @return
	 */
	public String getRelatetype();

}
