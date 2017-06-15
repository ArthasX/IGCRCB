/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/** 
 * 流程角色类型定义
 *
 */
public interface IG213Info  extends BaseModel {
	/**
	 * 流程角色类型定义ID取得
	 * @return 流程角色类型定义ID
	 */
	public String getPrtdid();
	
	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid();

	/**
	 * 流程角色类型取得
	 * @return 流程角色类型
	 */
	public String getRoletype();
	
}
