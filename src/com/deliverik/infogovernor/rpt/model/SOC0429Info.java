/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;


/**
  * ����: ����������ͼ�ӿ�
  * ��������: ����������ͼ�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWInfo������ΪSOC0429Info
  */
public interface SOC0429Info{

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getHostName();

	/**
	 * ҵ��ϵͳidȡ��
	 *
	 * @return ҵ��ϵͳid
	 */
	public Integer getBcid();
	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return bcName ҵ��ϵͳ����
	 */
	public String getBcName();

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getSName();

	/**
	 * ��¼ʱ��ȡ��
	 *
	 * @return ��¼ʱ��
	 */
	public String getCreateDate();

	/**
	 * �ѷ�������ȡ��
	 *
	 * @return �ѷ�������
	 */
	public Integer getAllottedCapacity();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getFreeCapacity();

}