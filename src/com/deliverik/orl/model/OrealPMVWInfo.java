/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.orl.model;

/**
 * ������ŷ���ż��ָ����ͼ�ӿ�
 * ����������ŷ���ż��ָ����ͼ�ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealPMVWInfo{
	/**
	 * ���ָ��ID(����)ȡ��
	 * @return id ���ָ��ID(����)
	 */
	public Integer getId();
	/**
	 * Agent��IDȡ��
	 * @return agent_id Agent��ID
	 */
	public Integer getAgent_id();
	/**
	 * IPȡ��
	 * @return ip IP
	 */
	public String getIp();
	/**
	 * ƽ̨IDȡ��
	 * @return platform_id ƽ̨ID
	 */
	public Integer getPlatform_id();
	/**
	 * ƽ̨����ȡ��
	 * @return platform_name ƽ̨����
	 */
	public String getPlatform_name();
	/**
	 * ָ�굥λȡ��
	 * @return units ָ�굥λ
	 */
	public String getUnits();
	/**
	 * �������ȡ��
	 * @return typename �������
	 */
	public String getTypename();
	/**
	 * ��ԴIDȡ��
	 * @return resource_id ��ԴID
	 */
	public Integer getResource_id();
	/**
	 * �Ƿ���(��ʶ)ȡ��
	 * @return enabled �Ƿ���(��ʶ)
	 */
	public Integer getEnabled();
	/**
	 * ���ָ��ֵȡ��
	 * @return id ���ָ��ֵ
	 */
	public Double getValue();
}
