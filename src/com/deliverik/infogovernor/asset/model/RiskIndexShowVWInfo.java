/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ָ��չʾ��ѯ�ӿ�
  * ��������: ����ָ��չʾ��ѯ�ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexShowVWInfo extends BaseModel {

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEsyscoding();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRisknum();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRisk();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskly();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskarea();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskitem();

}