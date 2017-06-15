package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 风险检查信息检索结果ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGVEN01022VO extends BaseVO implements Serializable{
	/** 频率为天内容 */
	protected String dayvalue;
	
	/** 是否已选择标识 */
	protected String ischecked;
	
	/** 频率为周内容 */
	protected String weekvalue;
	
	/** 周文字显示 */
	protected String weekdata;
	
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
	
}


