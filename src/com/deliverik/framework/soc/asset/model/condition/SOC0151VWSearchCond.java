/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: SOC0151VW���������ӿ�
  * ��������: SOC0151VW���������ӿ�
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
public interface SOC0151VWSearchCond {
	/**
	 * �ʲ�����ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�����ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory();

	/**
	 * �ʲ�����ȡֵ��Χ״̬ȡ��
	 * @return �ʲ�����ȡֵ��Χ״̬
	 */
	public String getCcdstatus();

	/**
	 * �ʲ�����ȡֵ��Χ����Ӧ��ȡ��
	 * @return �ʲ�����ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype();
	
	/**
	 * @return the id
	 */
	public Integer getId();
}