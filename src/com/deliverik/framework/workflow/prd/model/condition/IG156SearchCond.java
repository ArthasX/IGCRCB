/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ����״̬��ť�������������ӿ�
  * ��������: ����״̬��ť�������������ӿ�
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
public interface IG156SearchCond {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPseid();


	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();


	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPsdid();


	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getPseactionid();


	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPseorder();


	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsedec();
	
	
	public String getPsebuttonid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPseid_like();
}