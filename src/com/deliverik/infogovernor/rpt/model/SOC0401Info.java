/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ݿ�����ʵʱ��ӿ�
  * ��������: ���ݿ�����ʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��DBCapacityRealTimeInfo������ΪSOC0401Info
  */
public interface SOC0401Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getDbId();

	/**
	 * ���ݿ���ȡ��
	 *
	 * @return ���ݿ���
	 */
	public String getDbName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName();

	/**
	 * ����ȡ��
	 *
	 * @return ����
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

	/**
	 * ��ʹ������ȡ��
	 *
	 * @return ��ʹ������
	 */
	public Integer getUsedCapacity();

}