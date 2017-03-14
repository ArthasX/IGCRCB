package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.scheduling.form.IGSCH0101Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;

public class IGSCH01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	
	private List<QuartzJobs> quartzJobsList;

	private QuartzJobsSearchCond quartzJobsSearchCond;
	
	private QuartzJobs quartzJobs;
	
	private QuartzProcessRecord  quartzProcessRecord;
	
	private List<QuartzProcessInfo> quartzProcessInfoList;
	
	private List <QuartzProcessParticipant> quartzProcessParticipantList;
	
	private List<Attachment> attachmentList;
	
	private List<String> usernameList;
	
	private String einame;
	
	private String cvalue;
	
	private String username;
		//============================>>yangsn
	/** 流程与资产关系 */
	private List<QuartzProcessInfoEntity> quartzProcessInfoEntityList;
	
	/** 相关资产信息 */
	private List<QuartzProcessInfoEntity> quartzPieList;
	
	/** 定时任务查询 */
	private QuartzJobDetailsSearchCond quartzJobDetailsSearchCond;
	
	/** 定时任务查询列表 */
	private List<QuartzJobDetails> quartzJobDetailsList;
	//<<============================yangsn
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
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

	/**
	 * 允许查询的最大记录数
	 */
	
	private int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	private PagingDTO pagingDto;
	
	/**
	 * 删除主键
	 */
	
	private int qjid;
	
	/**
	 * 变更用基本信息
	 */
	private IGSCH0101Form igsch0101Form;

	public QuartzJobsSearchCond getQuartzJobsSearchCond() {
		return quartzJobsSearchCond;
	}

	public void setQuartzJobsSearchCond(QuartzJobsSearchCond quartzJobsSearchCond) {
		this.quartzJobsSearchCond = quartzJobsSearchCond;
	}


	public List<QuartzJobs> getQuartzJobsList() {
		return quartzJobsList;
	}

	public void setQuartzJobsList(List<QuartzJobs> quartzJobsList) {
		this.quartzJobsList = quartzJobsList;
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

	public IGSCH0101Form getIgsch0101Form() {
		return igsch0101Form;
	}

	public void setIgsch0101Form(IGSCH0101Form igsch0101Form) {
		this.igsch0101Form = igsch0101Form;
	}

	public int getQjid() {
		return qjid;
	}

	public void setQjid(int qjid) {
		this.qjid = qjid;
	}
	
	//============================>>yangsn
	/**
	 * 流程与资产关系取得
	 * @return 流程与资产关系
	 */
	public List<QuartzProcessInfoEntity> getQuartzProcessInfoEntityList() {
		return quartzProcessInfoEntityList;
	}

	/**
	 * 流程与资产关系设定
	 * @param quartzProcessInfoEntityList 流程与资产关系
	 */
	public void setQuartzProcessInfoEntityList(
			List<QuartzProcessInfoEntity> quartzProcessInfoEntityList) {
		this.quartzProcessInfoEntityList = quartzProcessInfoEntityList;
	}

	/**
	 * 相关资产信息取得
	 * @return 相关资产信息
	 */
	public List<QuartzProcessInfoEntity> getQuartzPieList() {
		return quartzPieList;
	}

	/**
	 * 相关资产信息设定
	 * @param pieList 相关资产信息
	 */
	public void setQuartzPieList(List<QuartzProcessInfoEntity> quartzPieList) {
		this.quartzPieList = quartzPieList;
	}

	/**
	 * 定时任务查询取得
	 * @return 定时任务查询
	 */
	public QuartzJobDetailsSearchCond getQuartzJobDetailsSearchCond() {
		return quartzJobDetailsSearchCond;
	}

	/**
	 * 定时任务查询设定
	 * @param quartzJobDetailsSearchCond 定时任务查询
	 */
	public void setQuartzJobDetailsSearchCond(
			QuartzJobDetailsSearchCond quartzJobDetailsSearchCond) {
		this.quartzJobDetailsSearchCond = quartzJobDetailsSearchCond;
	}

	/**
	 * 定时任务查询列表取得
	 * @return 定时任务查询列表
	 */
	public List<QuartzJobDetails> getQuartzJobDetailsList() {
		return quartzJobDetailsList;
	}

	/**
	 * 定时任务查询列表设定
	 * @param quartzJobDetailsList 定时任务查询列表
	 */
	public void setQuartzJobDetailsList(List<QuartzJobDetails> quartzJobDetailsList) {
		this.quartzJobDetailsList = quartzJobDetailsList;
	}
	
	//<<============================yangsn

	public List<QuartzProcessParticipant> getQuartzProcessParticipantList() {
		return quartzProcessParticipantList;
	}

	public void setQuartzProcessParticipantList(
			List<QuartzProcessParticipant> quartzProcessParticipantList) {
		this.quartzProcessParticipantList = quartzProcessParticipantList;
	}

}