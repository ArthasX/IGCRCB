/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Զ������̻�����Χ��ӿ�
  * ��������: �Զ������̻�����Χ��ӿ�
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
public interface IG123Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPotdid();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getPdid();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOrgid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname();

}