/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程关系实体接口
 *
 */
public interface IG512Info extends BaseModel {
	
	/**
	 * 流程关系ID取得
	 * 
	 * @return 流程关系ID
	 */
	public Integer getPrrid();

	/**
	 * 主动流程ID取得
	 * 
	 * @return 主动流程ID
	 */
	public Integer getParprid();
	
	/**
	 * 主动流程信息取得
	 * 
	 * @return 主动流程信息
	 */
	public IG500Info getParProcess();

	/**
	 * 被动流程ID取得
	 * 
	 * @return 被动流程ID
	 */
	public Integer getCldprid();
	
	/**
	 * 被动流程信息取得
	 * 
	 * @return 被动流程信息
	 */
	public IG500Info getCldProcess();

	/**
	 * 关系建立时间取得
	 * 
	 * @return 关系建立时间
	 */
	public String getPrrinstime();

}