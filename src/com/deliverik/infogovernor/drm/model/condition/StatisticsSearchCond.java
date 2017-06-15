/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 应急管理模块-统计分析查询条件接口
  * 功能描述: 应急管理模块-统计分析查询条件接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface StatisticsSearchCond {

	/**预案登记时间开始*/
	public String getEiinstimeFrom();
	/**预案登记时间结束*/
	public String getEiinstimeTo();
	/**演练统计时间条件开始*/
	public String 	getDrillTimeFrom();
	/**演练统计时间条件终止*/
	public String 	getDrillTimeTo();
	/**
	 * @return the 专项预案名称
	 */
	public String getEiname();
	/**
	 * @return the 资产码
	 */
	public String getEsyscoding();
	
}