/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ����״̬�����ߵ������������ӿ�
  * ��������: ����״̬�����ߵ������������ӿ�
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
public interface IG258SearchCond {
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPspcdid();

	/**
	 * ��ǰ״̬IDȡ��
	 *
	 * @return ��ǰ״̬ID
	 */
	public String getPsdid();

	/**
	 * �ɸı�״̬idȡ��
	 *
	 * @return �ɸı�״̬id
	 */
	public String getPspcdpsdid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPspcdid_like();
}	