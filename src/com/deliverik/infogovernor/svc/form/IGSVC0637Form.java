/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top5统计Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC0637Form extends BaseForm{

	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;
	
	/** 类型 */
	protected String type;

	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 类型取得
	 * @return type 类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型设定
	 * @param type 类型
	 */
	public void setType(String type) {
		this.type = type;
	}
}
