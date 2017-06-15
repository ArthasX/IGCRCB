/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.scheduling.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.infogovernor.scheduling.form.IGSCH0501Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0502Form;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

/**
 * <p>
 * 概述：运维计划定时发起DTO
 * </p>
 * <p>
 * 创建: 杨盛楠	2010-12-9
 * </p>
 */
public class IGSCH05DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/** 定时任务信息 */
	private QuartzJobs quartzJobs;
	
	/** 定时任务流程信息 */
	private QuartzProcessRecord quartzProcessRecord;
	
	/** 角色列表 */
	private List<Role> rolelist;
	
	/** quartz任务名称 */
	private String triggerName;
	
	/** 流程类型列表 */
	private List<IG380Info> pdList;
	
	/** 流程表单信息列表 */
	private List<IG007Info> pidList;
	
	/** 流程表单定义信息 */
	private IG007Info processInfoDef;
	
	/** 流程类型ID */
	private Integer pdid;
	
	/** 定时任务igsch0501Form信息 */
	private IGSCH0501Form igsch0501Form;
	
	/** 定时任务igsch0502Form信息 */
	private IGSCH0502Form igsch0502Form;
	
	/**
	 * 流程类型列表取得
	 * @return 流程类型列表
	 */
	public List<IG380Info> getPdList() {
		return pdList;
	}

	/**
	 * 流程类型列表设定
	 * @param pdList 流程类型列表
	 */
	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	/**
	 * 流程表单信息列表取得
	 * @return 流程表单信息列表
	 */
	public List<IG007Info> getPidList() {
		return pidList;
	}

	/**
	 * 流程表单信息列表设定
	 * @param pidList 流程表单信息列表
	 */
	public void setPidList(List<IG007Info> pidList) {
		this.pidList = pidList;
	}

	/**
	 * 流程表单定义信息取得
	 * @return 流程表单定义信息
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * 流程表单定义信息设定
	 * @param processInfoDef 流程表单定义信息
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * 流程类型ID取得
	 * @return 流程类型ID
	 */
	public Integer getPdid() {
		return pdid;
	}

	/**
	 * 流程类型ID设定
	 * @param pdid 流程类型ID
	 */
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	/**
	 * quartz任务名称取得
	 * @return quartz任务名称
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * quartz任务名称设定
	 * @param triggerName quartz任务名称
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * 定时任务信息取得
	 * @return 定时任务信息
	 */
	public QuartzJobs getQuartzJobs() {
		return quartzJobs;
	}

	/**
	 * 定时任务信息设定
	 * @param quartzJobs 定时任务信息
	 */
	public void setQuartzJobs(QuartzJobs quartzJobs) {
		this.quartzJobs = quartzJobs;
	}

	/**
	 * 角色列表取得
	 * @return 角色列表
	 */
	public List<Role> getRolelist() {
		return rolelist;
	}

	/**
	 * 角色列表设定
	 * @param rolelist 角色列表
	 */
	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}

	/**
	 * 定时任务流程信息取得
	 * @return 定时任务流程信息
	 */
	public QuartzProcessRecord getQuartzProcessRecord() {
		return quartzProcessRecord;
	}

	/**
	 * 定时任务流程信息设定
	 * @param quartzProcessRecord 定时任务流程信息
	 */
	public void setQuartzProcessRecord(QuartzProcessRecord quartzProcessRecord) {
		this.quartzProcessRecord = quartzProcessRecord;
	}

	/**
	 * 定时任务igsch0501Form信息取得
	 * @return 定时任务igsch0501Form信息
	 */
	public IGSCH0501Form getIgsch0501Form() {
		return igsch0501Form;
	}

	/**
	 * 定时任务igsch0501Form信息设定
	 * @param igsch0501Form 定时任务igsch0501Form信息
	 */
	public void setIgsch0501Form(IGSCH0501Form igsch0501Form) {
		this.igsch0501Form = igsch0501Form;
	}

	/**
	 * 定时任务igsch0502Form信息取得
	 * @return 定时任务igsch0502Form信息
	 */
	public IGSCH0502Form getIgsch0502Form() {
		return igsch0502Form;
	}

	/**
	 * 定时任务igsch0502Form信息设定
	 * @param igsch0502Form 定时任务igsch0502Form信息
	 */
	public void setIgsch0502Form(IGSCH0502Form igsch0502Form) {
		this.igsch0502Form = igsch0502Form;
	}

}