/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
 * 
 * 场景资产查询页面VO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01081VO extends BaseVO implements Serializable {

	/** 场景信息 */
	protected PlanInfo planInfo;

	/***
	 * 应急资源集合
	 * */
	protected List<SOC0118VWInfo> zyList;
	/**
	 * 预期恢复时间
	 */
	protected String expectTime;
	
	/**  
	 * 获取expectTime  
	 * @return expectTime 
	 */
	public String getExpectTime() {
		return expectTime;
	}

	/**  
	 * 设置expectTime  
	 * @param expectTime
	 */
	
	public void setExpectTime(String expectTime) {
		this.expectTime = expectTime;
	}

	public List<SOC0118VWInfo> getZyList() {
		return zyList;
	}

	public void setZyList(List<SOC0118VWInfo> zyList) {
		this.zyList = zyList;
	}

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

}
