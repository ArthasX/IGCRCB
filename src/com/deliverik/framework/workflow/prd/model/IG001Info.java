/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: OA��ɫ���ñ�ӿ�
  * ��������: OA��ɫ���ñ�ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG001Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getProid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getProtype();

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getProroleid();

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getProrolename();

}