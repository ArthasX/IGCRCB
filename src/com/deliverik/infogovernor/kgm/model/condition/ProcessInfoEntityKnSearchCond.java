/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * �����ʲ���ϵ��ѯ�ӿ�
 *
 */
public interface ProcessInfoEntityKnSearchCond {
	
	/**
	*��������������
	*/
	public Integer getPiekid();
	
	/**
	*����ID(Ig500Kn��)
	*/
	public Integer getPrkid();

	/**
	*��̬��ID��IG007��
	*/
	public Integer getPidid();

	/**
	*�ʲ�ID(EntityItem��)
	*/
	public Integer getEiid();
}
