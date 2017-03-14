package com.deliverik.infogovernor.rdp.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGRDP0101Form extends BaseForm {

	protected String bsmid;
	
	protected String scriptPath;
	
	protected String rdpFilePath;
	
	protected String scriptParam;
	
	protected String resultLogPath;
	
	protected String[] hostips;
	
	protected String taskName;
	
	protected String currentFilePath;
	
	protected String time_from;
	
	protected String time_to;
	
	protected String taskName_like;
	
	protected String taskid_eq;
	
	protected String scriptName; 
	

	public String getBsmid() {
		return bsmid;
	}

	public void setBsmid(String bsmid) {
		this.bsmid = bsmid;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	public String getRdpFilePath() {
		return rdpFilePath;
	}

	public void setRdpFilePath(String rdpFilePath) {
		this.rdpFilePath = rdpFilePath;
	}

	public String getScriptParam() {
		return scriptParam;
	}

	public void setScriptParam(String scriptParam) {
		this.scriptParam = scriptParam;
	}

	public String getResultLogPath() {
		return resultLogPath;
	}

	public void setResultLogPath(String resultLogPath) {
		this.resultLogPath = resultLogPath;
	}

	public String[] getHostips() {
		return hostips;
	}

	public void setHostips(String[] hostips) {
		this.hostips = hostips;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCurrentFilePath() {
		return currentFilePath;
	}

	public void setCurrentFilePath(String currentFilePath) {
		this.currentFilePath = currentFilePath;
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

	public String getTaskName_like() {
		return taskName_like;
	}

	public void setTaskName_like(String taskName_like) {
		this.taskName_like = taskName_like;
	}

	public String getTaskid_eq() {
		return taskid_eq;
	}

	public void setTaskid_eq(String taskid_eq) {
		this.taskid_eq = taskid_eq;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	
}
