/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ״̬��������Ϣ
 */
public interface StatusParticipantInfo {
	
	/**
	 * ��־������Ϣȡ��
	 * 
	 * @return ��־������Ϣ
	 */
	public WorkFlowLogInfo getLogInfo();

	/**
	 * ���̴����ɫIDȡ��
	 * 
	 * @return ���̴����ɫID
	 */
	public Integer getRoleid();

	/**
	 * ����״̬����ȡ��
	 * 
	 * @return ����״̬����
	 */
	public String getStatusname();

	/**
	 * ���̴�����IDȡ��
	 * 
	 * @return ���̴�����ID
	 */
	public String getUserid();
	
	/**
	 * ״̬��ȡ��
	 * @return statuscode ״̬��
	 */
	public String getStatuscode();
	
}
