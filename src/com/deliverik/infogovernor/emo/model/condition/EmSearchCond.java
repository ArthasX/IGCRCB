/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model.condition;

/**
  * ����: oracle���ܲɼ����������ӿ�
  * ��������: oracle���ܲɼ����������ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface EmSearchCond {
	/**
	 * ����ȡ��
	 * @return em_type ����
	 */
	public String getEm_type();
	/**
	 * ���ʱ��ȡ��
	 * @return max_collecttime ���ʱ��
	 */
	public String getMax_collecttime();
	/**
	 * �ܺ͵���ȡ��
	 * @return order_Totail_desc �ܺ͵���
	 */
	public String getOrder_Totail_desc();
	/**
	 * ʵ����
	 * @return fingerprint 
	 */
	public String getFingerprint();
}