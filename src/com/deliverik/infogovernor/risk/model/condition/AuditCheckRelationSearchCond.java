package com.deliverik.infogovernor.risk.model.condition;



/**
 * ���ռ�������������ϵ��Ϣ��ѯ�����ӿ�
 * 
 */
public interface AuditCheckRelationSearchCond {
	/**
	 * ���ռ���������ƹ�ϵID
	 * @return ���ռ���������ƹ�ϵID
	 */
	public Integer getAcrid();

	
	/**
	 * ���ռ��ID
	 * @return ���ռ��ID
	 */
	public Integer getRcid();

	/**
	 * ���������ID
	 * @return ���������ID
	 */
	public Integer getRadid();

	/**
	 * ������������
	 * @return ������������
	 */
	public String getRadcode();
	
	
}
