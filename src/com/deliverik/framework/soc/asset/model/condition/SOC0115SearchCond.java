/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ������������������ӿ�
  * ��������: ������������������ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface SOC0115SearchCond {
	
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