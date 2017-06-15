/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * 年报填报业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR01DTO extends BaseDTO implements Serializable{
	
	/** 用户信息 */
	protected User user;
	
	/** 年报发起Form */
	protected IGSMR0101Form igSMR0101Form;
	
	/** 审批意见信息 */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** 审批意见信息集合 */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
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
	 * 年报发起Form取得
	 * 
	 * @return 年报发起Form
	 */
	public IGSMR0101Form getIgSMR0101Form() {
		return igSMR0101Form;
	}

	/**
	 * 年报发起Form设定
	 * 
	 * @param igSMR0101Form 年报发起Form
	 */
	public void setIgSMR0101Form(IGSMR0101Form igSMR0101Form) {
		this.igSMR0101Form = igSMR0101Form;
	}
	
}