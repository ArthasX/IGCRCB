/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.condition.AttachmentSearchCond;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;

public class IGSDL01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private IGSDL0110Form igsdl0110Form;
	protected int maxSearchCount;
	protected PagingDTO pagingDto;
	private AttachmentSearchCond attachmentSearchCond;
	private String filePath;
	private List<QuartzJobs> quartzJobsList;
	
	private List<String> usernameList;
	
	private String username;
	
	private List<QuartzJobsDetail> quartzJobsDetailList;
	private String userid;
	
	private List<QuartzJobsDetail> quartzJobDetailList;
	
	
	
	public List<QuartzJobsDetail> getQuartzJobDetailList() {
		return quartzJobDetailList;
	}

	public void setQuartzJobDetailList(List<QuartzJobsDetail> quartzJobDetailList) {
		this.quartzJobDetailList = quartzJobDetailList;
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

	public List<QuartzJobs> getQuartzJobsList() {
		return quartzJobsList;
	}

	public void setQuartzJobsList(List<QuartzJobs> quartzJobsList) {
		this.quartzJobsList = quartzJobsList;
	}

	public IGSDL0110Form getIgsdl0110Form() {
		return igsdl0110Form;
	}

	public void setIgsdl0110Form(IGSDL0110Form igsdl0110Form) {
		this.igsdl0110Form = igsdl0110Form;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public AttachmentSearchCond getAttachmentSearchCond() {
		return attachmentSearchCond;
	}

	public void setAttachmentSearchCond(AttachmentSearchCond attachmentSearchCond) {
		this.attachmentSearchCond = attachmentSearchCond;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<QuartzJobsDetail> getQuartzJobsDetailList() {
		return quartzJobsDetailList;
	}

	public void setQuartzJobsDetailList(List<QuartzJobsDetail> quartzJobsDetailList) {
		this.quartzJobsDetailList = quartzJobsDetailList;
	}

}
