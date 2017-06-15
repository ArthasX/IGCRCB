/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;

/**
 * 
 * 场景资产查询页面VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01191VO extends BaseVO implements Serializable {


	/** 场景响应策略集合 */
	protected List<ResponseStrategyInfo> responseStrategyList;

	protected ResponseStrategyInfo responseStrategyInfo;;

	/** 场景信息 */
	protected PlanInfo planInfo;

	/**
	 * 预期恢复时间
	 */
	protected String expectTime;

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

	public String getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public List<ResponseStrategyInfo> getResponseStrategyList() {
		return responseStrategyList;
	}

	public void setResponseStrategyList(List<ResponseStrategyInfo> responseStrategyList) {
		this.responseStrategyList = responseStrategyList;
	}

	public ResponseStrategyInfo getResponseStrategyInfo() {
		return responseStrategyInfo;
	}

	public void setResponseStrategyInfo(ResponseStrategyInfo responseStrategyInfo) {
		this.responseStrategyInfo = responseStrategyInfo;
	}

}
