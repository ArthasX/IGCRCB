/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训计划表检索条件接口
  * 功能描述: 培训计划表检索条件接口
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public interface TrainplanSearchCond {
	
	/**
	 * 发起人取得
	 *
	 * @return 发起人
	 */
	public String getTpusername();
	
	/**
	 * 发起部门取得
	 *
	 * @return 发起部门
	 */
	public String getTporgname();
	
	/**
	 * 计划发起时间开始时间取得
	 *
	 * @return 计划发起时间开始时间
	 */
	public String getStartTimeBegin();
	
	/**
	 * 计划发起时间结束时间取得
	 *
	 * @return 发起时间结束时间
	 */
	public String getStartTimeEnd();
	

}