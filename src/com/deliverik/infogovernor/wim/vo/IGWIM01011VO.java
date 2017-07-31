/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;

/**
 * @Description 工作项新增/修改VO
 * 
 * @date 2017年6月9日16:09:40
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM01011VO extends BaseVO{

	/** 频率为天内容 */
	protected String dayvalue;
	
	/** 是否已选择标识 */
	protected String ischecked;
	
	/** 频率为周内容 */
	protected String weekvalue;
	
	/** 周文字显示 */
	protected String weekdata;
	
	/** 小时内容 */
	protected String hourvalue;
	
	/** 分内容 */
	protected String minutesvalue;
	
	/** 工作项定义信息 */
	protected WorkDefinitionInfo workDefinitionInfo;
	
	/** 频率周星期集合 */
	protected List<IGWIM01011VO> weekList;
	
	/** 频率月天数集合 */
	protected List<IGWIM01011VO> monthList;
	
	/** 频率小时集合 */
	protected List<IGWIM01011VO> hourList;
	
	/** 频率分集合 */
	protected List<IGWIM01011VO> minutesList;
	
	/**
	 * 频率为天内容取得
	 * @return 频率为天内容
	 */
	public String getDayvalue() {
		return dayvalue;
	}
	
	/**
	 * 频率为天内容设定
	 *
	 * @param dayvalue 频率为天内容
	 */
	public void setDayvalue(String dayvalue) {
		this.dayvalue = dayvalue;
	}
	
	/**
	 * 是否已选择标识取得
	 * @return 是否已选择标识
	 */
	public String getIschecked() {
		return ischecked;
	}
	
	/**
	 * 是否已选择标识设定
	 *
	 * @param ischecked 是否已选择标识
	 */
	public void setIschecked(String ischecked) {
		this.ischecked = ischecked;
	}
	
	/**
	 * 频率为周内容取得
	 * @return 频率为周内容
	 */
	public String getWeekvalue() {
		return weekvalue;
	}
	
	/**
	 * 频率为周内容设定
	 *
	 * @param weekvalue 频率为周内容
	 */
	public void setWeekvalue(String weekvalue) {
		this.weekvalue = weekvalue;
	}
	
	/**
	 * 周文字显示取得
	 * @return 周文字显示
	 */
	public String getWeekdata() {
		return weekdata;
	}
	
	/**
	 * 周文字显示设定
	 *
	 * @param weekdata 周文字显示
	 */
	public void setWeekdata(String weekdata) {
		this.weekdata = weekdata;
	}

	/**
	 * 工作项定义信息取得
	 * @return 工作项定义信息
	 */
	public WorkDefinitionInfo getWorkDefinitionInfo() {
		return workDefinitionInfo;
	}

	/**
	 * 工作项定义信息设定
	 * @param 工作项定义信息
	 */
	public void setWorkDefinitionInfo(WorkDefinitionInfo workDefinitionInfo) {
		this.workDefinitionInfo = workDefinitionInfo;
	}

	/**
	 * 频率周星期集合取得
	 * @return 频率周星期集合
	 */
	public List<IGWIM01011VO> getWeekList() {
		return weekList;
	}

	/**
	 * 频率周星期集合设定
	 * @param 频率周星期集合
	 */
	public void setWeekList(List<IGWIM01011VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * 频率月天数集合取得
	 * @return 频率月天数集合
	 */
	public List<IGWIM01011VO> getMonthList() {
		return monthList;
	}

	/**
	 * 频率月天数集合设定
	 * @param 频率月天数集合
	 */
	public void setMonthList(List<IGWIM01011VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * 小时内容取得
	 * @return 小时内容
	 */
	public String getHourvalue() {
		return hourvalue;
	}

	/**
	 * 小时内容设定
	 * @param 小时内容
	 */
	public void setHourvalue(String hourvalue) {
		this.hourvalue = hourvalue;
	}

	/**
	 * 分内容取得
	 * @return 分内容
	 */
	public String getMinutesvalue() {
		return minutesvalue;
	}

	/**
	 * 分内容设定
	 * @param 分内容
	 */
	public void setMinutesvalue(String minutesvalue) {
		this.minutesvalue = minutesvalue;
	}
	
	/**
	 * 频率小时集合取得
	 * @return 频率小时集合
	 */
	public List<IGWIM01011VO> getHourList() {
		return hourList;
	}

	/**
	 * 频率小时集合设定
	 * @param 频率小时集合
	 */
	public void setHourList(List<IGWIM01011VO> hourList) {
		this.hourList = hourList;
	}

	/**
	 * 频率分集合取得
	 * @return 频率分集合
	 */
	public List<IGWIM01011VO> getMinutesList() {
		return minutesList;
	}

	/**
	 * 频率分集合设定
	 * @param 频率分集合
	 */
	public void setMinutesList(List<IGWIM01011VO> minutesList) {
		this.minutesList = minutesList;
	}
}
