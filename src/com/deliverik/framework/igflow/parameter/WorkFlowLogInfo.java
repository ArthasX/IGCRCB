/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ������־������Ϣ
 */
public interface WorkFlowLogInfo {
	
	/**
	 * ��Ȩ�û�IDȡ��
	 * 
	 * @return ��Ȩ�û�ID
	 */
	public String getAuthuserid();

	/**
	 * ��עȡ��
	 * 
	 * @return ��ע
	 */
	public String getComment();

	/**
	 * ��ǰ�û�IDȡ��
	 * 
	 * @return ��ǰ�û�ID
	 */
	public String getExecutorid();

	/**
	 * ���̴����ɫIDȡ��
	 * 
	 * @return ���̴����ɫID
	 */
	public Integer getExecutorRoleid();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();

}
