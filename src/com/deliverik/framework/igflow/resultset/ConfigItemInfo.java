/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * �ʲ�������Ϣ
 */
public interface ConfigItemInfo {
	
	/**
	 * �ʲ�����IDȡ��
	 * 
	 * @return �ʲ�����ID
	 */
	public Integer getCiid();
	
	/**
	 * �ʲ����Զ���IDȡ��
	 * 
	 * @return �ʲ����Զ���ID
	 */
	public String getCid();

	/**
	 * �ʲ���������ȡ��
	 * 
	 * @return �ʲ���������
	 */
	public String getName();

	/**
	 * �ʲ�����ֵȡ��
	 * 
	 * @return �ʲ�����ֵ
	 */
	public String getValue();

}
