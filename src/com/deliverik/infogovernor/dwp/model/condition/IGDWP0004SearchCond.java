/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划参与人信息查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0004SearchCond {

	/**
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid();

	/**
	 * 流程信息ID取得
	 * @return prid 流程信息ID
	 */
	public Integer getPrid();
}
