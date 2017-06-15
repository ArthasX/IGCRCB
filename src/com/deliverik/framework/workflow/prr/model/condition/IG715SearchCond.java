/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;


/**
 * 服务工单关联流程查询条件接口
 */
public interface IG715SearchCond {
	
	/**
	 * 主键ID取得
	 * 
	 * @return 主键ID
	 */
	public Integer getSprrid();

	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSprrsfid();
	
	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getSprrprid();

}
