/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0151VW�ӿ�
  * ��������: SOC0151VW�ӿ�
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
public interface SOC0151VWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getCcdid();

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory();

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ����ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public String getCcdlabel();

	/**
	 * �ʲ�ģ������ȡֵ��Χֵȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χֵ
	 */
	public String getCcdvalue();

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public String getCcdstatus();

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ��ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype();

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ�ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public String getCcdinfo();

}