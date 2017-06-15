/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_食堂接待收益统计FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0508Form extends BaseForm implements EentertainmentStatisticsSearchCond {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询条件
	 */
	public String ewhere;
	
	/**
	 * 食堂招待费用统计开始时间查询
	 */
	public String etime_from;
	
	/**
	 * 食堂招待费用统计结束时间查询
	 */
	public String etime_to;
	
	/** 统计开始年 */
	protected String yearFrom;

	/** 统计开始月 */
	protected String monthFrom;
	
	/** 统计结束年 */
	protected String yearTo;

	/** 统计结束月 */
	protected String monthTo;
	
	/**
	 * 统计开始年取得
	 * @return 统计开始年
	 */
	public String getYearFrom() {
		return yearFrom;
	}
	
	/**
	 * 统计开始年设定
	 * @param yearFrom 统计开始年
	 */
	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}
	
	/**
	 * 统计开始月取得
	 * @return 统计开始月
	 */
	public String getMonthFrom() {
		return monthFrom;
	}
	
	/**
	 * 统计开始月设定
	 * @param monthFrom 统计开始月
	 */
	public void setMonthFrom(String monthFrom) {
		this.monthFrom = monthFrom;
	}
	
	/**
	 * 统计结束年取得
	 * @return 统计结束年
	 */
	public String getYearTo() {
		return yearTo;
	}
	
	/**
	 * 统计结束年设定
	 * @param yearTo 统计结束年
	 */
	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}
	
	/**
	 * 统计结束月取得
	 * @return 统计结束月
	 */
	public String getMonthTo() {
		return monthTo;
	}
	
	/**
	 * 食堂招待费用统计开始时间查询设定
	 * @param etime_from 食堂招待费用统计开始时间查询
	 */
	public void setMonthTo(String monthTo) {
		this.monthTo = monthTo;
	}

	/**
	 * 食堂成本信息时间查询取得
	 * @return 食堂成本信息开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * 食堂招待费用统计开始时间查询设定
	 * @param etime_from 食堂招待费用统计开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * 食堂招待费用统计结束时间查询取得
	 * @return 食堂招待费用统计结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * 食堂招待费用统计结束时间查询设定
	 * @param etime_to 食堂招待费用统计结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * 查询条件
	 * @return 查询条件
	 */
	public String getEwhere() {
		return ewhere;
	}
	
	/**
	 * 查询条件
	 * @param ewhere 查询条件
	 */
	public void setEwhere(String ewhere) {
		this.ewhere = ewhere;
	}
}
