/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �ʲ�ģ������ȱʡֵ�ӿ�
  * ��������: �ʲ�ģ������ȱʡֵ�ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public interface IG611Info extends BaseModel {

	/**
	 * ģ��IDȡ��
	 *
	 * @return ģ��ID
	 */
	public Integer getEid();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getCid();

	/**
	 * ����ֵȡ��
	 *
	 * @return ����ֵ
	 */
	public String getCvalue();

}