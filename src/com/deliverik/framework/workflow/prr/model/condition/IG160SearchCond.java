/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���������Ա����ͳ�Ʋ�ѯ�����ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG160SearchCond {

	/**
	 * ���ܣ�����IDȡ��
	 * @return orgid ����ID
	 */
	public String getOrgid();
	
	/**
	 * ���ܣ���������ȡ��
	 * @return propentime_to ��������
	 */
	public String getPropentime_to();
	
	/**
	 * ���ܣ���ʼ����ȡ��
	 * @return propentime_from ��ʼ����
	 */
	public String getPropentime_from();
	
}
