/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̱���Ϣ
 */
public interface PrivateProcessFormInfo {
	
	/**
	 * �����߽�ɫIDȡ��
	 *
	 * @return �����߽�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * �������û�IDȡ��
	 * 
	 * @return �������û�ID
	 */
	public String getUserid();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getValue();
	
	/**
	 * ��ע��Ϣȡ��
	 * @return comment ��ע��Ϣ
	 */
	public String getComment();

}
