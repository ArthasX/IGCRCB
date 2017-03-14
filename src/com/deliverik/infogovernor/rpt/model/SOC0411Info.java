/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �洢����ʵʱ��ӿ�
  * ��������: �洢����ʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeInfo������ΪSOC0411Info
  */
public interface SOC0411Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getScid();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public Integer getRawCapacity();

	/**
	 * ��Ч����ȡ��
	 *
	 * @return ��Ч����
	 */
	public Integer getEffectiveCapacity();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getRedundancyCapacity();

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

	/**
	 * ���̸���ȡ��
	 *
	 * @return ���̸���
	 */
	public Integer getDiskCount();

}