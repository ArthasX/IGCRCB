/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * 审批意见查询VO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR02021VO  extends BaseVO implements Serializable {

	/** 流程主信息 */
	protected IG500Info ig500Info;
	
	/** 审批意见信息集合 */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;

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
	
}
