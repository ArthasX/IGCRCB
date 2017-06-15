package com.deliverik.infogovernor.rdp.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.rdp.form.IGRDP0101Form;
import com.deliverik.infogovernor.rdp.form.IGRDP0102Form;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;

@SuppressWarnings("serial")
public class IGRDP01DTO extends BaseDTO implements Serializable{
	
	//业务系统列表
	protected List<SOC0124Info> bsms;
	
	//业务系统eiid
	protected Integer bsmid;
	
	//带IP的主机视图列表
	protected List<SOC0123Info> hosts;
	
	protected IGRDP0101Form igrdp0101Form;
	
	protected IGRDP0102Form igrdp0102Form;
	
	protected Integer taskID;
	
	protected AutoTaskInfo task;
	
	protected List<ExcuteResultInfo> results;
	
	protected String errorMsg;
	
	protected List<AutoTaskInfo> tasks;
	
	protected String logPath;
	
	protected String log;
	
	protected String resultsStr;
	
	protected String logFlag;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	
	private String hostip;
	/**realTimeDetail id*/
	private Integer rtdId;
	
	private String realTimeDetailListJson;

	public List<ExcuteResultInfo> getResults() {
		return results;
	}

	public void setResults(List<ExcuteResultInfo> results) {
		this.results = results;
	}

	public List<SOC0124Info> getBsms() {
		return bsms;
	}

	public void setBsms(List<SOC0124Info> bsms) {
		this.bsms = bsms;
	}

	public Integer getBsmid() {
		return bsmid;
	}

	public void setBsmid(Integer bsmid) {
		this.bsmid = bsmid;
	}

	public List<SOC0123Info> getHosts() {
		return hosts;
	}

	public void setHosts(List<SOC0123Info> hosts) {
		this.hosts = hosts;
	}

	public IGRDP0101Form getIgrdp0101Form() {
		return igrdp0101Form;
	}

	public void setIgrdp0101Form(IGRDP0101Form igrdp0101Form) {
		this.igrdp0101Form = igrdp0101Form;
	}

	public AutoTaskInfo getTask() {
		return task;
	}

	public void setTask(AutoTaskInfo task) {
		this.task = task;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<AutoTaskInfo> getTasks() {
		return tasks;
	}

	public void setTasks(List<AutoTaskInfo> tasks) {
		this.tasks = tasks;
	}

	public IGRDP0102Form getIgrdp0102Form() {
		return igrdp0102Form;
	}

	public void setIgrdp0102Form(IGRDP0102Form igrdp0102Form) {
		this.igrdp0102Form = igrdp0102Form;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getResultsStr() {
		return resultsStr;
	}

	public void setResultsStr(String resultsStr) {
		this.resultsStr = resultsStr;
	}

	public String getLogFlag() {
		return logFlag;
	}

	public void setLogFlag(String logFlag) {
		this.logFlag = logFlag;
	}



	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	public String getRealTimeDetailListJson() {
		return realTimeDetailListJson;
	}

	public void setRealTimeDetailListJson(String realTimeDetailListJson) {
		this.realTimeDetailListJson = realTimeDetailListJson;
	}

	public Integer getRtdId() {
		return rtdId;
	}

	public void setRtdId(Integer rtdId) {
		this.rtdId = rtdId;
	}

	
	
	
	

}
