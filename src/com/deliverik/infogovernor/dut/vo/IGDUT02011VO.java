/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * ֵ��ƻ�
 */
public class IGDUT02011VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGDUT02012VO> weekVOList;
	private int calendarYear;
	private int calendarMonth;

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

	public List<IGDUT02012VO> getWeekVOList() {
		return weekVOList;
	}

	public void setWeekVOList(List<IGDUT02012VO> weekVOList) {
		this.weekVOList = weekVOList;
	}

}
