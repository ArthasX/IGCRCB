package com.deliverik.infogovernor.broker.collect;

import java.util.Date;
import java.util.List;

public class CollectBean {
	
	private String uuid;
	private String status;
	private String jobName;
	private String jobType;
	private String timeRule;
	private int resourceId;
	private Date stopTime;
	private Date startTime;
	private String executStatus;
	private String[] metricNames;
	
	private String triggerName;
	private String jobGroupName;
	private String triggerGroupName;
	private String periodtype;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getTimeRule() {
		return timeRule;
	}
	public void setTimeRule(String timeRule) {
		this.timeRule = timeRule;
	}
	public String getExecutStatus() {
		return executStatus;
	}
	public void setExecutStatus(String executStatus) {
		this.executStatus = executStatus;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStartTime() {
		return startTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getTriggerName() {
		triggerName = CollectUnit.TRIGGER_NAME.name() + "_" + getUuid();
		return triggerName;
	}
	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}
	public String getJobGroupName() {
		jobGroupName = CollectUnit.JOB_GROUP_NAME.name() + "_" + getUuid();
		return jobGroupName;
	}
	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}
	public String getTriggerGroupName() {
		triggerGroupName = CollectUnit.TRIGGER_GROUP_NAME.name() + "_"+ getUuid();
		return triggerGroupName;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}
	public String getPeriodtype() {
		return periodtype;
	}
	public void setMetricNames(String[] metricNames) {
		this.metricNames = metricNames;
	}
	public String[] getMetricNames() {
		return metricNames;
	}
	
}
