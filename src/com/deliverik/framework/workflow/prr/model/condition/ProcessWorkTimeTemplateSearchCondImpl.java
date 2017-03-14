/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 作息时间模板定义表检索条件实现
  * 功能描述: 作息时间模板定义表检索条件实现
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public class ProcessWorkTimeTemplateSearchCondImpl implements
		ProcessWorkTimeTemplateSearchCond {
	//查询日期
	protected String date_like;

	/**
	 * 查询日期获取
	 */
	public String getDate_like() {
		return date_like;
	}

	/**
	 * 查询日期设定
	 * @param date_like
	 */
	public void setDate_like(String date_like) {
		this.date_like = date_like;
	}

}