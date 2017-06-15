/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �洢lunʵʱ��ӿ�
  * ��������: �洢lunʵʱ��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeInfo������ΪSOC0410Info
  */
public interface SOC0410Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPsId();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getSName();

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

	/**
	 * �Ƿ񱻷���ȡ��
	 *
	 * @return �Ƿ񱻷���
	 */
	public String getIsUsed();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCreateDate();

}