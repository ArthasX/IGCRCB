/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

import java.util.Map;

/**
 * ���̷�����Ϣ
 */
public interface ProcessRecordInfo {
	
	/**
	 * ���̷�����IDȡ��
	 * 
	 * @return ���̷�����ID
	 */
	public String getCrtuserid();

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getDefid();
	
	/**
	 * ���̶���״̬ȡ��
	 * 
	 * @return ���̶���״̬
	 */
	public String getDefstatus();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getDescription();

	/**
	 * ��ֵ����ȡ��
	 * 
	 * @return ��ֵ����
	 */
	public Map<String, String> getFormvalue();
	
	/**
	 * ��־������Ϣȡ��
	 * 
	 * @return ��־������Ϣ
	 */
	public WorkFlowLogInfo getLogInfo();

	/**
	 * ���̷����ɫIDȡ��
	 * 
	 * @return ���̷����ɫID
	 */
	public Integer getRoleid();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getTitle();
	
	/**
	 * ������ʵ��IDȡ��
	 * 
	 * @return ������ʵ��ID
	 */
	public Integer getGroupID();

	/**
	 * �����鶨��IDȡ��
	 * 
	 * @return �����鶨��ID
	 */
	public String getGroupDefID();
	
}
