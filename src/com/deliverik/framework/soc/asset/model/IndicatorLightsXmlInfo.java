/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯ϵͳ��ʾ�����ӿ�
  * ��������: �澯ϵͳ��ʾ�����ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsXmlInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIxid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getIxtitle();

	/**
	 * λ��X����ȡ��
	 *
	 * @return λ��X����
	 */
	public String getIxplacex();

	/**
	 * λ��Y����ȡ��
	 *
	 * @return λ��Y����
	 */
	public String getIxplacey();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer getIxwidth();

	/**
	 * �߶�ȡ��
	 *
	 * @return �߶�
	 */
	public Integer getIxheight();

	/**
	 * rotationȡ��
	 *
	 * @return rotation
	 */
	public String getRotation();

}