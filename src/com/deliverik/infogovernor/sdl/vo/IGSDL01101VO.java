/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

public class IGSDL01101VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<QuartzJobs> quartzJobsList;

	private User user;
	
	private QuartzJobs quartzJobs;
	
	private QuartzProcessRecord quartzProcessRecord;

	private List<QuartzProcessInfo> quartzProcessInfoList;
	
	private List<String> usernameList;
	
	private String username;
	
	private List<QuartzJobsDetail> quartzJobsDetailList;
	
	public List<QuartzJobsDetail> getQuartzJobsDetailList() {
		return quartzJobsDetailList;
	}

	public void setQuartzJobsDetailList(List<QuartzJobsDetail> quartzJobsDetailList) {
		this.quartzJobsDetailList = quartzJobsDetailList;
	}
	
	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<QuartzProcessInfo> getQuartzProcessInfoList() {
		return quartzProcessInfoList;
	}

	public void setQuartzProcessInfoList(
			List<QuartzProcessInfo> quartzProcessInfoList) {
		this.quartzProcessInfoList = quartzProcessInfoList;
	}

	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}
	
	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<QuartzJobs> getQuartzJobsList() {
		return quartzJobsList;
	}

	public void setQuartzJobsList(List<QuartzJobs> quartzJobsList) {
		this.quartzJobsList = quartzJobsList;
	}

	
	
}
