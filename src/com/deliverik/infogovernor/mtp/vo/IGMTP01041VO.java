/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.mtp.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 工作计划
 */
public class IGMTP01041VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGMTP01042VO> weekVOList;//周列表
	private int calendarYear;//年
	private int calendarMonth;//月

	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	public List<IGMTP01042VO> getWeekVOList() {
		return weekVOList;
	}

	public void setWeekVOList(List<IGMTP01042VO> weekVOList) {
		this.weekVOList = weekVOList;
	}

}
