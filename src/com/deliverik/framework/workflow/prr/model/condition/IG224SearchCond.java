/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>
 * 流程状态日志检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>流程ID</td>
 * </tr>
 * <tr>
 * <td>currentPrstatus</td>
 * <td>是否查询流程当前状态记录标识</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG224SearchCond {

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 是否查询流程当前状态记录标识取得
	 * 
	 * @return 是否查询流程当前状态记录标识
	 */
	public boolean isCurrentPrstatus();

	/**
	 * 流程状态NOT取得
	 * @return 流程状态NOT
	 */
	public String getPrstatus_ne();
	
	/**
	 * 流程状态获取
	 * @return 流程状态获取
	 */
	public String getPrstatus();

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid();
	

	/**
	 * 上级流程状态定义ID取得
	 * @return 上级流程状态定义ID
	 */
	public String getPpsdid();
	

	/**
	 * 虚拟节点状态取得
	 * @return 虚拟节点状态
	 */
	public String getVirtualstatus();
	

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum();

	/**
	 * 当前状态取得
	 * @return 当前状态
	 */
	public String getNowstatus();

	/**
	 * 是否挂起取得
	 * @return 是否挂起
	 */
	public boolean isPend();
}
