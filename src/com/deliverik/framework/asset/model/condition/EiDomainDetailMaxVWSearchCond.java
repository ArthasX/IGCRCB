/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.condition;

/**
 * ����: �ʲ�����ϸ�����������ӿ�
 * ��������: �ʲ�����ϸ�����������ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDetailMaxVWSearchCond {
	
	
	/**��ȡ�ʲ���ID**/
	public String getEiddid();
	
	/**
	 * ��ѯ����ȡ��
	 * @return ��ѯ����
	 */
	public String getTypeId();
	
	/** Ӱ��CI */
	public String getEilabel();
	
	/**��ȡ�ʲ���汾**/
	public String getEiddversion();
	
	public String getEiname();
	
	public String getEiid();
	
	
}