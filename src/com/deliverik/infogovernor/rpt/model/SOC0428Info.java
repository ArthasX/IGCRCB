/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

/**
  * ����: ҵ��ϵͳ��ͼ�ӿ�
  * ��������: ҵ��ϵͳ��ͼ�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��BusinessCapacityRealTimeVWInfo������ΪSOC0428Info
  */
public interface SOC0428Info {
	/**
	 * ҵ��ϵͳIDȡ��
	 *
	 * @return ҵ��ϵͳID
	 */
	public Integer getBcid();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName();

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return bcName ҵ��ϵͳ����
	 */
	public String getBcName();

	/**
	 * �ѷ�������ȡ��
	 *
	 * @return �ѷ�������
	 */
	public Integer getAllottedCapacity();

}