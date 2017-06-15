/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划查询VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01011VO extends BaseVO{

	/** 日常工作计划信息集合 */
	protected List<IGDWP0001Info> dayWorkPlanList;

	/**
	 * 日常工作计划信息集合取得
	 * @return dayWorkPlanList 日常工作计划信息集合
	 */
	public List<IGDWP0001Info> getDayWorkPlanList() {
		return dayWorkPlanList;
	}

	/**
	 * 日常工作计划信息集合设定
	 * @param dayWorkPlanList 日常工作计划信息集合
	 */
	public void setDayWorkPlanList(List<IGDWP0001Info> dayWorkPlanList) {
		this.dayWorkPlanList = dayWorkPlanList;
	}
}
