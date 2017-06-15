/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
/**
 * 概述:作息日期模板画面日历VO
 * 创建记录：张楠    2011/10/18
 * 功能描述：SOC原作息时间设定
 * 修改时间：LuJiayuan 2013/01/29 代码合并将原IGSYM17012VO更名IGSYM19012VO
 */
@SuppressWarnings("serial")
public class IGSYM19012VO extends BaseVO implements Serializable{
	
	/**
	 * 年份
	 */
	protected String year;
	
	/**
	 * 月份
	 */
	protected String month;
	
	/**
	 * 日
	 */
	protected String day;
	
	/**
	 * 工时
	 */
	protected Integer factTime;
	
	/**
	 * 日历单元格颜色
	 */
	protected String cellColor;
	
	/**
	 * 日期颜色
	 */
	protected String dayColor;
	
	/**
	 * 主键
	 */
	protected Integer pwtId;
	
	/**
	 * 节假日
	 */
	protected Integer pwtSleepTime;
	
	/**
	 * 日获取
	 * @return
	 */
	public String getDay() {
		return day;
	}

	/**
	 * 日设定
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * 工时获取
	 * @return
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * 工时设定
	 * @param factTime
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * 日历单元格颜色获取
	 * @return
	 */
	public String getCellColor() {
		return cellColor;
	}

	/**
	 * 日历单元格颜色设定
	 * @param color
	 */
	public void setCellColor(String cellColor) {
		this.cellColor = cellColor;
	}

	/**
	 * 主键获取
	 * @return
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * 主键设定
	 * @param pwtId
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

	/**
	 * 查询年份获取
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 查询年份设定
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月份获取
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 节假日获取
	 * @return
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * 节假日设定
	 * @param pwtSleepTime
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
	}

	/**
	 * 日期颜色获取
	 * @return
	 */
	public String getDayColor() {
		return dayColor;
	}

	/**
	 * 日期颜色设定
	 * @param dayColor
	 */
	public void setDayColor(String dayColor) {
		this.dayColor = dayColor;
	}
}
