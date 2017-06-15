/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决事件统计实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentAveSolveTimeVWInfo {

	/**
	 * 事件类型取得
	 * @return itype 事件类型
	 */
	public String getItype();

	/**
	 * 平均解决事件取得
	 * @return solveTime 平均解决事件
	 */
	public String getSolveTime();
}
