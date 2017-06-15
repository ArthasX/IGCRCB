/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * 审批意见新增VO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR02011VO  extends BaseVO implements Serializable {

	/** 审批意见信息 */
	protected ApproveSuggestionInfo approveSuggestionInfo;

	/** 流程主信息 */
	protected IG500Info ig500Info;

	/** 表单名称 */
	protected String pidname;
	
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
