/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

public class AdvancesummaryCondImpl implements AdvancesummaryCond {
    
	/** 查询年 */
	protected String year;

	/**
	 * 查询年取得
	 * @return 查询年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 查询年设定
	 * @param year 查询年
	 */
	public void setYear(String year) {
		this.year = year;
	}


}
