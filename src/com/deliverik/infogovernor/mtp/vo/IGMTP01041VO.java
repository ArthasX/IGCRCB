/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.mtp.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * �����ƻ�
 */
public class IGMTP01041VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGMTP01042VO> weekVOList;//���б�
	private int calendarYear;//��
	private int calendarMonth;//��

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
