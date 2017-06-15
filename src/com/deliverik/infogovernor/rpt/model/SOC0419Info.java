/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��������ʵʱ��ӿ�
  * ��������: ��������ʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��VGCapacityRealTimeInfo������ΪSOC0419Info
  */
public interface SOC0419Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getVgId();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getVgName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName();

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