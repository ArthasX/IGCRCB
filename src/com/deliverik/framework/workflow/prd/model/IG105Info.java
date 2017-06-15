/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 流程策略设定信息接口
 * 功能描述：流程策略设定信息接口
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public interface IG105Info  extends BaseModel {

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public String getPrstatus();

	/**
	 * 紧急程度取得
	 * 
	 * @return 紧急程度
	 */
	public String getPrurgency();

	/**
	 * 策略版本取得
	 * 
	 * @return 策略版本
	 */
	public Integer getPsdversion();

	/**
	 * 期望解决时间取得
	 * 
	 * @return 期望解决时间
	 */
	public Double getExpecttime();
	
	/**
	 * 策略创建时间取得
	 * 
	 * @return 策略创建时间
	 */
	public String getCreatetime();

}