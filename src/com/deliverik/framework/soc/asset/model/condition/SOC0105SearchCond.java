/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ��ƴ�����������������ӿ�
  * ��������: ��ƴ�����������������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0105SearchCond {
	
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