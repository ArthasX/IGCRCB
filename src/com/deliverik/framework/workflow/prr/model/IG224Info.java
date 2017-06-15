/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

import java.util.Date;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程状态日志实体接口
 *
 */
public interface IG224Info extends BaseModel {
	
	/**
	 * 流程状态日志ID取得
	 * 
	 * @return 流程状态日志ID
	 */
	public Integer getRslid();

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 自定义流程类型ID取得
	 * 
	 * @return 自定义流程类型ID
	 */
	public String getPrpdid();
	
	/**
	 * 流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPrtype();

	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public String getPrstatus();
	
	/**
	 * 开始时间取得
	 * 
	 * @return 开始时间
	 */
	public Date getRslOpenTime();
	
	/**
	 * 结束时间取得
	 * 
	 * @return 结束时间
	 */
	public Date getRslCloseTime();
	
	/**
	 * 是否超时取得
	 * 
	 * @return 是否超时
	 */
	public String getRslExpect();
	
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
}