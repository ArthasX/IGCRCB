/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ȱʡ�����߰�ť�������������ӿ�
  * ��������: ȱʡ�����߰�ť�������������ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG725SearchCond {
	
	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ��ťIDȡ��
	 *
	 * @return ��ťID
	 */
	public String getPbdid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPdbdid_like();
}