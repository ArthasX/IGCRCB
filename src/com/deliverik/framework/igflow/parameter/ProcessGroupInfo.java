/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;



/**
 * �����鷢����Ϣ
 */
public interface ProcessGroupInfo {
	
	/**
	 * �����鷢����IDȡ��
	 * 
	 * @return �����鷢����ID
	 */
	public String getCrtuserid();

	/**
	 * �����鶨��IDȡ��
	 * 
	 * @return �����鶨��ID
	 */
	public String getDefid();
	
	/**
	 * �����鶨��״̬ȡ��
	 * 
	 * @return �����鶨��״̬
	 */
	public String getDefstatus();

	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getDescription();

	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getTitle();
	
	/**
	 * ����ʵ������ȡ��
	 * @param pdid ���̶���ID
	 * @return ����ʵ������
	 */
	public String getProcessTitle(String pdid);
	
}
