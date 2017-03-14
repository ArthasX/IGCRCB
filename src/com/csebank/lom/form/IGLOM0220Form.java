/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 每月盘点form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0220Form extends BaseForm implements InventorySearchCond{
	
	/** 年 */
	protected String year;
	
	/** 月 */
	protected String month;

	/**
	 * 年取得
	 * @return 年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年设定
	 * @param year 年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月取得
	 * @return 月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月设定
	 * @param month 月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	

}
