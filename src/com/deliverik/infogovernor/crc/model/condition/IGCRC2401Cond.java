/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
 * 概述: 事件平均解决时间检索条件接口
 */
public interface IGCRC2401Cond {
	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear();
	/**
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth();
	/**
	 * 部门取得
	 * @return dept 部门
	 */
	public String getDept();
	
	/***
	 *  1.事件。
	 *  2.告警
	 * @return
	 */
	public String getSign();

}
