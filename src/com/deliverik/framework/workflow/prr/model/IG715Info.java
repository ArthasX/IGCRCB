/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * 
 * 服务工单关联流程接口
 * 
 * 
 */

public interface IG715Info extends BaseModel {
	
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
	
	/**
	 * 添加时间取得
	 * 
	 * @return 添加时间
	 */
	public String getSprrinstime();

	/**
	 * 服务工单对象取得
	 * 
	 * @return 服务对象
	 */
	public IG933TB getServiceFormTB();
	
	/**
	 * 流程对象取得
	 * 
	 * @return 流程对象
	 */
	public IG500TB getProcessRecordTB();	
}