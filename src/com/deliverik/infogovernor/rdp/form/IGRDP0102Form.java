package com.deliverik.infogovernor.rdp.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGRDP0102Form extends BaseForm {
	
	protected String taskid_eq;
	
	protected String isquery;

	public String getTaskid_eq() {
		return taskid_eq;
	}

	public void setTaskid_eq(String taskid_eq) {
		this.taskid_eq = taskid_eq;
	}

	public String getIsquery() {
		return isquery;
	}

	public void setIsquery(String isquery) {
		this.isquery = isquery;
	}
	
}
