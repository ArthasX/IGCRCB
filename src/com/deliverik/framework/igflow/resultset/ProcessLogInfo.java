/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ������־��Ϣ
 */
public interface ProcessLogInfo {

	/**
	 * �ύʱ��ȡ��
	 * @return �ύʱ��
	 */
	public String getCommittime();

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getPlid();

	/**
	 * ״̬IDȡ��
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * �����¼ȡ��
	 * @return �����¼
	 */
	public String getRecord();

	/**
	 * �����ɫIDȡ��
	 * @return �����ɫID
	 */
	public Integer getRoleid();

	/**
	 * �����ɫ����ȡ��
	 * @return �����ɫ����
	 */
	public String getRolename();
	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getUserid();
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getUsername();
	
}
