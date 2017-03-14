/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * 审批意见业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR02DTO extends BaseDTO implements Serializable{
	
	/** 用户信息 */
	protected User user;
	
	/** 审批意见Form */
	protected IGSMR0201Form igSMR0201Form;
	
	/** 审批意见查询Form */
	protected IGSMR0202Form igSMR0202Form;
	
	/** 审批意见信息 */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** 审批意见信息集合 */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
	/** 流程主信息 */
	protected IG500Info ig500Info;

	/** 表单名称 */
	protected String pidname;
	
	
	/**
	 * 审批意见Form取得
	 *
	 * @return igSMR0201Form 审批意见Form
	 */
	public IGSMR0201Form getIgSMR0201Form() {
		return igSMR0201Form;
	}

	/**
	 * 审批意见Form设定
	 *
	 * @param igSMR0201Form 审批意见Form
	 */
	public void setIgSMR0201Form(IGSMR0201Form igSMR0201Form) {
		this.igSMR0201Form = igSMR0201Form;
	}

	/**
	 * 审批意见查询Form取得
	 *
	 * @return igSMR0202Form 审批意见查询Form
	 */
	public IGSMR0202Form getIgSMR0202Form() {
		return igSMR0202Form;
	}

	/**
	 * 审批意见查询Form设定
	 *
	 * @param igSMR0202Form 审批意见查询Form
	 */
	public void setIgSMR0202Form(IGSMR0202Form igSMR0202Form) {
		this.igSMR0202Form = igSMR0202Form;
	}

	/**
	 * 审批意见信息集合取得
	 *
	 * @return lstApproveSuggestionInfo 审批意见信息集合
	 */
	public List<ApproveSuggestionInfo> getLstApproveSuggestionInfo() {
		return lstApproveSuggestionInfo;
	}

	/**
	 * 审批意见信息集合设定
	 *
	 * @param lstApproveSuggestionInfo 审批意见信息集合
	 */
	public void setLstApproveSuggestionInfo(
			List<ApproveSuggestionInfo> lstApproveSuggestionInfo) {
		this.lstApproveSuggestionInfo = lstApproveSuggestionInfo;
	}

	/**
	 * 审批意见信息取得
	 *
	 * @return approveSuggestionInfo 审批意见信息
	 */
	public ApproveSuggestionInfo getApproveSuggestionInfo() {
		return approveSuggestionInfo;
	}

	/**
	 * 审批意见信息设定
	 *
	 * @param approveSuggestionInfo 审批意见信息
	 */
	public void setApproveSuggestionInfo(ApproveSuggestionInfo approveSuggestionInfo) {
		this.approveSuggestionInfo = approveSuggestionInfo;
	}

	/**
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * 
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 流程主信息取得
	 *
	 * @return ig500Info 流程主信息
	 */
	public IG500Info getIg500Info() {
		return ig500Info;
	}

	/**
	 * 流程主信息设定
	 *
	 * @param ig500Info 流程主信息
	 */
	public void setIg500Info(IG500Info ig500Info) {
		this.ig500Info = ig500Info;
	}

	/**
	 * 表单名称取得
	 * 
	 * @return 表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单名称设定
	 * 
	 * @param pidname 表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

}