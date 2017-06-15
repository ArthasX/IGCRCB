/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务策略_查询VO
 * </p>
 * 
 * @author zhaoyunli@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGMTP01051VO extends BaseVO implements Serializable {

	private List<QuartzJobs> quartzJobsList;

	private User user;
	
	private QuartzJobs quartzJobs;
	
	private QuartzProcessRecord quartzProcessRecord;

	private List<QuartzProcessInfo> quartzProcessInfoList;
	
	private List<Attachment> attachmentList;
	
	private String einame;
	
	private String cvalue;

	//============================>>yangsn
	/** 流程与资产关系 */
	private List<QuartzProcessInfoEntity> quartzProcessInfoEntityList;
	
	/** 相关资产别表 */
	private List<QuartzProcessInfoEntity> quartzPieList;
	
	/** 定时任务查询信息集合 */
	private List<QuartzJobDetails> quartzJobDetailsList;
	//<<============================yangsn
	
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
	 * 相关资产别表取得
	 * @return 相关资产别表
	 */
	public List<QuartzProcessInfoEntity> getQuartzPieList() {
		return quartzPieList;
	}

	/**
	 * 相关资产别表设定
	 * @param quartzPieList 相关资产别表
	 */
	public void setQuartzPieList(List<QuartzProcessInfoEntity> quartzPieList) {
		this.quartzPieList = quartzPieList;
	}

	/**
	 * 定时任务查询信息集合取得
	 * @return 定时任务查询信息集合
	 */
	public List<QuartzJobDetails> getQuartzJobDetailsList() {
		return quartzJobDetailsList;
	}

	/**
	 * 定时任务查询信息集合设定
	 * @param quartzJobDetailsList 定时任务查询信息集合
	 */
	public void setQuartzJobDetailsList(List<QuartzJobDetails> quartzJobDetailsList) {
		this.quartzJobDetailsList = quartzJobDetailsList;
	}

	
	
}
