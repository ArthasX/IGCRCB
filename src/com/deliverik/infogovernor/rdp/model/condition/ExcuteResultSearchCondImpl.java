/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * ����: ExcuteResult��������ʵ��
  * ��������: ExcuteResult��������ʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public class ExcuteResultSearchCondImpl implements
		ExcuteResultSearchCond {
	
	protected Integer taskID_eq;

	public Integer getTaskID_eq() {
		return taskID_eq;
	}

	public void setTaskID_eq(Integer taskID_eq) {
		this.taskID_eq = taskID_eq;
	}

}