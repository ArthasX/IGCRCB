/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ˽�б���Ϣ
 */
public interface PrivateProcessInfoValueInfo {
	
	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getFormname();

	/**
	 * ��ֵȡ��
	 * 
	 * @return ��ֵ
	 */
	public String getFormvalue();
	
	/**
	 * ��־������Ϣȡ��
	 * 
	 * @return ��־������Ϣ
	 */
	public WorkFlowLogInfo getLogInfo();

}
