/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̲�������Ϣ
 */
public interface ParticipantInfo {
	
	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getOrgid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getOrgname();

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid();

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename();
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUsername();
	
	/**
	 * �ֻ���ȡ��
	 * @return �ֻ���
	 */
	public String getPhone();
	
	/**
	 * ����ʼʱ��ȡ��
	 * @return ����ʼʱ��
	 */
	public String getPpinittime();

	/**
	 * �������ʱ��ȡ��
	 * @param ppopentime �������ʱ�� 
	 */
	public String getPpproctime();
}
