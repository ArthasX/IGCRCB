/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���������ӿ�
  * ��������: ���������ӿ�
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListInfo������ΪSOC0423Info
  */
public interface SOC0423Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getName();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectType();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectName();
	/**
	 * �������ȡ��
	 *
	 * @return errorNum �������
	 */
	public Integer getErrorNum();
	/**
	 * �澯����ȡ��
	 *
	 * @return warningNum �澯����
	 */
	public Integer getWarningNum();
	/**
	 * ״̬ȡ��
	 *
	 * @return status ״̬
	 */
	public Integer getStatus();

}