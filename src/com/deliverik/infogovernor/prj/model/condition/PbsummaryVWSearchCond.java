/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.condition;


/**
 * <p>概述:预算及工程分类信息视图查询条件接口</p>
 */

public interface PbsummaryVWSearchCond {
	/**
	 * 获取预算项目关系表ID
	 * @return 预算项目关系表ID
	 */
	public Integer getPbid();
	
	/**
	 * 获取项目ID
	 * @return 项目ID
	 */
	public Integer getPid();
	
	/**
	 * 获取预算表ID
	 * @return 预算表ID
	 */
	public Integer getBid();
	
	/**
	 * 获取开始预算年份
	 * @return 开始预算年份
	 */
	public String getByear_begin();
	
	/**
	 * 获取结束预算年份
	 * @return 结束预算年份
	 */
	public String getByear_end();
}
