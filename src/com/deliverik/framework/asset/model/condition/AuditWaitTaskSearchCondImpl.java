/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ��ƴ����������������ʵ��
  * ��������: ��ƴ����������������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditWaitTaskSearchCondImpl implements
		AuditWaitTaskSearchCond {
	
	/** ����״̬�Ƿ���� */
	protected boolean taskDone;
	
	/** �����Ƿ������� */
	protected boolean taskError;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag_eq;

	/**
	 * ����״̬�Ƿ����ȡ��
	 * 
	 * @return ����״̬�Ƿ����
	 */
	public boolean isTaskDone() {
		return taskDone;
	}

	/**
	 * ����״̬�Ƿ�����趨
	 * 
	 * @param ����״̬�Ƿ����
	 */
	public void setTaskDone(boolean taskDone) {
		this.taskDone = taskDone;
	}
	
	/**
	 * �����Ƿ�������ȡ��
	 * 
	 * @return �����Ƿ�������
	 */
	public boolean isTaskError() {
		return taskError;
	}

	/**
	 * �����Ƿ��������趨
	 * 
	 * @param taskError �����Ƿ�������
	 */
	public void setTaskError(boolean taskError) {
		this.taskError = taskError;
	}

	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param deleteflag_eq �߼�ɾ����ʶ
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}

}