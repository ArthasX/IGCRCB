/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: �û���Ϣʱ�䶨�����������ӿ�
  * ��������: �û���Ϣʱ�䶨�����������ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeSearchCond {
	
	/**
	 * @return ��ѯ��ʼ����
	 */
	public String getStartDate();

	/**
	 * @return ��ѯ��������
	 */
	public String getEndDate();

	/**
	 * @return ��ѯ��������
	 */
	public String getPwDate();

	/**
	 * @return ��ѯ�û��޸ı�ʶλ
	 */
	public String getPwFlg();
	
	/**
	 * ��ѯ��ݻ�ȡ
	 * @return
	 */
	public String getPwDate_like();
	
	/**
	 * @return ��ѯ�û�ID
	 */
	public String getUserId();

}