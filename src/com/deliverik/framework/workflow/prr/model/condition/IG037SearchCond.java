/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ���̵�����־����������ӿ�
  * ��������: ���̵�����־����������ӿ�
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public interface IG037SearchCond {
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getPrid();
	
	/**
	 * ���̵����û�IDȡ��
	 * @return ���̵����û�ID
	 */
	public String getIruserid();
	
	/**
	 * ���̵��벿��IDȡ��
	 * @return ���̵��벿��ID
	 */
	public String getIrorgid();
	
	/**
	 * ���̵��벿��ID��ƥ��ȡ��
	 * @return ���̵��벿��ID��ƥ��
	 */
	public String getIrorgid_like_l();

}