/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �ԱȽ����Ϣ����������ӿ�
  * ��������: �ԱȽ����Ϣ����������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIResultSearchCond {

	/**
	 * ʱ��� ��ʼȡ��
	 * @return ʱ��� ��ʼ
	 */
	public String getCitime_from();

	/**
	 * ʱ��� ����ȡ��
	 * @return ʱ��� ����
	 */
	public String getCitime_to();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCitdesc();
	
	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding();

}