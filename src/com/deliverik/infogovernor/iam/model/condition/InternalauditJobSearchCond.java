/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ���ù�������������ӿ�
  * ��������: ���ù�������������ӿ�
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
public interface InternalauditJobSearchCond {

	/**
	 * ��ȼƻ�
	 */
	public String getIajYear_q();
	/**
	 * ��������
	 */
	public String getIajName_like();
	/**
	 * ������ĿID
	 */
	public Integer getIajIapId_q();
}