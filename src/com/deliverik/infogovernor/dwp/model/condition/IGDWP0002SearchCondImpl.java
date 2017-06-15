/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划流程信息查询条件实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0002SearchCondImpl implements IGDWP0002SearchCond{

	/** 计划ID */
	protected Integer planid;

	/**
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * 计划ID设定
	 * @param planid 计划ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}
}
