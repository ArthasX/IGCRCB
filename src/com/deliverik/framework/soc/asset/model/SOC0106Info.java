/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0106�ӿ�
  * ��������: SOC0106�ӿ�
  * ������¼: 2012/07/31
  * �޸ļ�¼: 
  */
public interface SOC0106Info extends BaseModel {

	/**
	 * awtIdȡ��
	 *
	 * @return awtId
	 */
	public Integer getAwtId();

	/**
	 * �ļ�����ȡ��
	 *
	 * @return �ļ�����
	 */
	public String getFileName();

	/**
	 * batNameȡ��
	 *
	 * @return batName
	 */
	public String getBatName();

	/**
	 * ʵ������ȡ��
	 *
	 * @return ʵ������
	 */
	public String getEiName();

	/**
	 * ʵ��Idȡ��
	 *
	 * @return ʵ��Id
	 */
	public String getAuwtId();

}