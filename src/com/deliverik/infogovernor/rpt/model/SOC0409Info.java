/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����pvʵʱ��ӿ�
  * ��������: ����pvʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeInfo������ΪSOC0409Info
  */
public interface SOC0409Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPhId();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName();

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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate();

	/**
	 * lunidȡ��
	 *
	 * @return lunid
	 */
	public String getLunid();

	/**
	 * pv��Сȡ��
	 *
	 * @return pv��С
	 */
	public Integer getPvSize();

}