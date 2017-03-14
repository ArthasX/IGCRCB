/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model.condition;

import java.util.List;

/**
  * 概述: 评分历史查询检索条件接口
  * 功能描述: 评分历史查询检索条件接口
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public interface AssessmentScoreVWSearchCond {
	
	/**prid取得*/
	public Integer getPrid();
	
	/**报表年度查询条件*/
	public String getCurrentyear() ;
	
	/**部门报表开始时间*/
	public String getBegintime();
	
	/**部门报表结束时间 */
	public String getEndtime();
	
	/** userid取得 */
	public String getUserid();
	
	/**
	 * 风险评估流程pdids list取得
	 */
	public List<String> getList();
	
	/**
	 * 风险评估部门评估统计使用   topOrgid取得
	 */
	public String getTopOrgid();
}