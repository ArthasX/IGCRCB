/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 
 * �����ʲ���ϵ��ѯ�ӿ�
 *
 */
public interface IG731SearchCond {
	
	/**
	*��������������
	*/
	public Integer getPieid();
	
	/**
	*����ID(IG500��)
	*/
	public Integer getPrid();

	/**
	 * ���̱�����ȡ��
	 *
	 * @return piid ���̱�����
	 */
	public Integer getPiid();
	
	/**
	*��̬��ID��IG007��
	*/
	public Integer getPidid();

	/**
	*�ʲ�ID(EntityItem��)
	*/
	public Integer getEiid();
	
	/**
	 * �Ƿ�Ϊ�����������ʲ�ȡ��
	 * @return tableColumnValue �Ƿ�Ϊ�����������ʲ�
	 */
	public String getTableColumnValue();
}
