/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 预支明细统计Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0317Form extends BaseForm implements AdvanceDetailSearchCond {
	
	/**
	 * 查询时间开始
	 */
	protected String date_from;
	
	/**
	 * 查询时间结束
	 */
	protected String date_to;

	/**
	 * 查询时间开始设定
	 * @return 查询时间开始
	 */
	public String getDate_from() {
		return date_from;
	}

	/**
	 * 查询时间开始设定
	 * @param date_from 查询时间开始
	 */
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	/**
	 * 查询时间结束设定
	 * @return 查询时间结束
	 */
	public String getDate_to() {
		return date_to;
	}

	/**
	 * 查询时间结束设定
	 * @param date_to 查询时间结束
	 */
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
}
