/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �߼�������ʵʱ��ӿ�
  * ��������: �߼�������ʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeInfo������ΪSOC0405Info
  */
public interface SOC0405Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getLvId();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getHostName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getVgName();

	/**
	 * �߼�������ȡ��
	 *
	 * @return �߼�������
	 */
	public String getLvType();

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public String getLvName();

	/**
	 * �߼����Сȡ��
	 *
	 * @return �߼����С
	 */
	public Integer getLvSize();

	/**
	 * �߼���״̬ȡ��
	 *
	 * @return �߼���״̬
	 */
	public String getLvState();

	/**
	 * �ļ�ϵͳ��ȡ��
	 *
	 * @return �ļ�ϵͳ��
	 */
	public String getFsName();

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