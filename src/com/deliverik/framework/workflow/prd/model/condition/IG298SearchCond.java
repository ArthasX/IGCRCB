/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣ���������ӿ�
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣ���������ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface IG298SearchCond {
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public Integer getRoleid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPsrdid_like();

}