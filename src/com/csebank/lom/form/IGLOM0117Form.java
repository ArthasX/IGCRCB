/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 模块：后前管理-接待管理
 * 说明：外出就餐月度统计Form
 * 作者：唐晓娜
 */
public class IGLOM0117Form extends BaseForm implements DealVWSearchCond {
	
	
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
