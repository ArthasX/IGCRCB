/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ���̼�ʱ����������ӿ�
  * ��������: ���̼�ʱ����������ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessTimeSearchCond {
	/**
	 * @return ��ѯ���
	 */
	public String getYear();
	
	/**
	 * @return ��ѯ�û�id
	 */
	public String getUserId();

	/**
	 * @return ��ѯ��ʱ��ʼʱ��
	 */
	public String getPrtstartTime_le();

	/**
	 * @return ��ѯ��ʱ����ʱ��
	 */
	public String getPrtEndTime_ge();
	
	/**
	 * @return ����ID
	 */
	public Integer getPrid();
	
}