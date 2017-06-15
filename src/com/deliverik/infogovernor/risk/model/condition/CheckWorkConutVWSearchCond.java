/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查工作统计报表检索条件接口
  * 功能描述: 检查工作统计报表检索条件接口
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public interface CheckWorkConutVWSearchCond {
	
	//检查方式查询条件
	public String getRcrtestmode();
	/**获取时间*/
	public String getDatetime();
	/**获取季度sql*/
	public String getQuart();
	/**获取半年sql*/
	public String getHalfyear();
	/**获取年sql*/
	public String getYear();
	/**获取常规sql*/
	public String getCg() ;
}