/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model;
/**
 * ����: ���°�����Ϣ�ӿ� 
 * ��������: ���°�����Ϣ�ӿ� 
 * ������¼: 2011/05/25 
 * �޸ļ�¼:
 */
public interface SOC0125Info {
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getName();

	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getDescription();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getCreatetime();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getUpdatetime();

}
