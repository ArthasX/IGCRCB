/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * �û���Ϣ
 */
public interface UserInfo {
	
	/**
	 * �������������ȡ��
	 *
	 * @return �������������
	 */
	public String getOrgid();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	
	public String getOrgname();

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getUserinfo();

	/**
	 * �ֻ���ȡ��
	 *
	 * @return �ֻ���
	 */
	public String getUsermobile();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUsername();
	
	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUseremail();

}
