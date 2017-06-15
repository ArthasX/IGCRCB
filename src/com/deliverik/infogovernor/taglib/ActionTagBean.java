package com.deliverik.infogovernor.taglib;

import java.io.Serializable;
import java.util.List;

public class ActionTagBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 菜单ID */
	protected String actname;

	/** 菜单显示名称 */
	protected String actlabel;

	/** 菜单URL */
	protected String acturl;
	
	protected String acturlType;

	protected List<ActionTagBean> actionList;

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActlabel() {
		return actlabel;
	}

	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	public String getActurl() {
		return acturl;
	}

	public void setActurl(String acturl) {
		this.acturl = acturl;
	}

	public List<ActionTagBean> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionTagBean> actionList) {
		this.actionList = actionList;
	}

	public String getActurlType() {
		return acturlType;
	}

	public void setActurlType(String acturlType) {
		this.acturlType = acturlType;
	}

}
