/**
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model.condition;

import java.util.List;

/**
 * 
 * 值班检查项检查时间查询接口
 *
 */
public interface DutyPersonSearchCond {
	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid();
	/**
	 * 值班人ID取得
	 * @return 值班人ID
	 */
	public String getDperuserid();
	
	/**
	 * 白班夜班取得
	 * @return 白班夜班
	 */
	public String getDptype();
	
	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDpertime();
	
	/**
	 * 值班计划集合取得
	 * @return 值班计划集合
	 */
	public List<Integer> getDpidList();
}
