/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: compareTemplate�ӿ�
  * ��������: compareTemplate�ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface CompareTemplateInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCtpid();

	/**
	 * ���IDȡ��
	 *
	 * @return ���ID
	 */
	public String getCtcategory();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCttype();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCtxwidth();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCtywidth();

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getCtvalue();

}