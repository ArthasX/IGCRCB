/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����ⲿ���ö������������ӿ�
  * ��������: �����ⲿ���ö������������ӿ�
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
public interface IG992SearchCond {
	/**
	 * �ⲿ�¼�IDȡ��
	 * 
	 * @return �ⲿ�¼�ID
	 */
	public Integer getPedid();
	/**
	 * �ⲿ�¼�ȡ��
	 *
	 * @return �ⲿ�¼�
	 */
	public String getPedeventid();

	/**
	 * �ⲿ����ȡ��
	 *
	 * @return �ⲿ����
	 */
	public String getPedaction();
	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPeddesc();
}