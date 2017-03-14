/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * �ʲ���Ϣ
 */
public interface EntityItemInfo {
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�����ȡ��
	 * 
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �ʲ����ȡ��
	 * 
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ��������������ȡ��
	 * 
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();

	/**
	 * �ʲ�����ģ�Ͳ����ȡ��
	 * 
	 * @return �ʲ�����ģ�Ͳ����
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�������IDȡ��
	 * 
	 * @return �ʲ�������ID
	 */
	public String getEiuserid();

	/**
	 * �ʲ�����������ȡ��
	 * 
	 * @return �ʲ�����������
	 */
	public String getEiusername();

	/**
	 * �ʲ��汾ȡ��
	 * @return �ʲ��汾
	 */
	public Integer getEiversion();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();

	/**
	 * �ʲ�������Ϣ�б�ȡ��
	 * 
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<ConfigItemInfo> getConfigItems();

}