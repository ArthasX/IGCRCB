package com.deliverik.infogovernor.rdp.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;

@SuppressWarnings("serial")
public class IGRDP01011VO extends BaseVO implements Serializable{

	//带IP的主机视图列表
	protected List<SOC0123Info> hosts;
	
	protected List<AutoTaskInfo> tasks;

	public List<AutoTaskInfo> getTasks() {
		return tasks;
	}

	public void setTasks(List<AutoTaskInfo> tasks) {
		this.tasks = tasks;
	}

	public List<SOC0123Info> getHosts() {
		return hosts;
	}

	public void setHosts(List<SOC0123Info> hosts) {
		this.hosts = hosts;
	}
	
}
