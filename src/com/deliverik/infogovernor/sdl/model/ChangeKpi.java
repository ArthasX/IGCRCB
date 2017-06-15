/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_统计汇总_变更kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface ChangeKpi {

	/**
	 * 获取类型ID
	 * @return 类型Id
	 */
	public abstract Integer getTypeId();
	/**
	 * 获取类型名称
	 * @return 类型名称
	 */
	public abstract String getTypeName();

	/**
	 * 获取成功子状态
	 * @return 成功子状态
	 */
	public abstract Integer getSuccess();
	
	/**
	 * 获取存在问题子状态
	 * @return 存在问题子状态
	 */
	public abstract Integer getProblem();
	
	
	/**
	 * 获取失败子状态
	 * @return 失败子状态
	 */
	public abstract Integer getFail();
	

}