/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.scheduling.model.condition;

/**
 * 
 * �����ʲ���ϵ��ѯ�ӿ�
 *
 */
public interface QuartzProcessInfoEntitySearchCond {
	
	/**
	*��������������
	*/
	public Integer getQpieid();
	
	/**
	*����ID(QuartzProcessRecord��)
	*/
	public Integer getQprid();

	/**
	*��̬��ID��QuartzProcessInfoDef��
	*/
	public Integer getQpiid();

	/**
	*�ʲ�ID(EntityItem��)
	*/
	public Integer getQeiid();
}
