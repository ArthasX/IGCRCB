/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ������������������ӿ�
  * ��������: ������������������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIWaitTaskSearchCond {
	
	/**
	 * ����״̬�Ƿ����ȡ��
	 * 
	 * @return ����״̬�Ƿ����
	 */
	public boolean isTaskDone();
	
	/**
	 * �����Ƿ�������ȡ��
	 * 
	 * @return �����Ƿ�������
	 */
	public boolean isTaskError();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq();

}