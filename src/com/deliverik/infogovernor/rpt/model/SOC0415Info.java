/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ռ�����ʵʱ��ӿ�
  * ��������: ��ռ�����ʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��TSCapacityRealTimeInfo������ΪSOC0415Info
  */
public interface SOC0415Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTsId();

	/**
	 * ��ռ���ȡ��
	 *
	 * @return ��ռ���
	 */
	public String getTsName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName();

	/**
	 * ���ݿ���ȡ��
	 *
	 * @return ���ݿ���
	 */
	public String getDbName();

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