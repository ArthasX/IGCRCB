/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * ����: AutoTask��������ʵ��
  * ��������: AutoTask��������ʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public class AutoTaskSearchCondImpl implements
		AutoTaskSearchCond {
	
	protected Integer systemid_eq;
	
	protected String taskName_like;
	
	protected String time_from;
	
	protected String time_to;

	public Integer getSystemid_eq() {
		return systemid_eq;
	}

	public void setSystemid_eq(Integer systemid_eq) {
		this.systemid_eq = systemid_eq;
	}

	public String getTaskName_like() {
		return taskName_like;
	}

	public void setTaskName_like(String taskName_like) {
		this.taskName_like = taskName_like;
	}

	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}
	
}