/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:存储实时信息视图Cond接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWSearchCond {
	/**
	 *序列号
	 */
	public String getSymmid();
	
	/**
	 * 查询时间开始
	 */
	public String getDate_from();
		
	/**
	 * 查询时间结束
	 */
	public String getDate_to();
	
	/**
	 * 存储类型
	 */
	public String getServerType();
}
