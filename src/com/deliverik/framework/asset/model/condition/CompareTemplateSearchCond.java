/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;


/**
  * ����: compareTemplate���������ӿ�
  * ��������: compareTemplate���������ӿ�
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public interface CompareTemplateSearchCond {

	/**
	 * ���IDȡ��
	 *
	 * @return ���ID
	 */
	public String getCategory();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getType();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getXwidth();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getYwidth();

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getValue();
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCabtype();
	
	/**
	 * ͼ������ȡ��
	 *
	 * @return ͼ������
	 */
	public String[] getLegendArray();

}