/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ������Ϣ
 */
public interface OrganizationInfo {
	
	/**
	 * ʱ���ȡ��
	 * @return fingerPrint ʱ���
	 */
	public String getFingerPrint();
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname();
	
	/**
	 * �������������ȡ��
	 *
	 * @return �������������
	 */
	public String getOrgsyscoding();
}