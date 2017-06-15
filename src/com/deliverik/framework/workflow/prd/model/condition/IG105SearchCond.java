/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 概述: 流程策略设定信息检索条件接口
 * 功能描述：流程策略设定信息检索条件接口
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public interface IG105SearchCond {
	
	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid();
	
	/**
	 * 策略版本取得
	 * 
	 * @return 策略版本
	 */
	public Integer getPsdversion();
	
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
}
