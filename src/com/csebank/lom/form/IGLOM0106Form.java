/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待工作月度统计Form
 *
 */
public class IGLOM0106Form extends BaseForm implements RecptionVWSearchCond {
	
	
	private static final long serialVersionUID = 1L;

	
	/** 查询日期段开始 */
	protected String rtime_from;
	
	/** 查询日期段结束 */
	protected String rtime_to;
	
	protected String year;

	/**
	 * 查询日期段开始取得
	 * @return 查询日期段开始
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * 查询日期段开始设定
	 * @param rtime_from 查询日期段开始
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * 查询日期段结束取得
	 * @return 查询日期结束
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * 查询日期段结束设定
	 * @param rtime_to 查询日期段开始
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
