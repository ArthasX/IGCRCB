/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决时间统计查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentAveSolveTimeSearchCond {

	/**
	 * 事件流程定义ID取得
	 * @return ipdid 事件流程定义ID
	 */
	public String getIpdid();

	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear();

	/**
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth();
}
