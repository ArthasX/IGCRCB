/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̲������Ѽ��������ӿ�
  * ��������: ���̲������Ѽ��������ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG256SearchCond {
	/**
	 * ��ȡ����ID
	 * @return
	 */
	public Integer getPrid();
	
	/**
	 * ��ȡ����״̬
	 * @return
	 */
	public String getPrstatus();
	
	/**
	 * ֪ͨ��ʶ��ȡ 
	 * @return
	 */
	public String getFlag();
	
	/**
	 * ��ȡ֪ͨ��ʶ in
	 * @return
	 */
	public String[] getFlag_in();
	
}