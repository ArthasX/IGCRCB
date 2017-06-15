package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
//VO
public class IGALM04021VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;

	/** 告警信息查询 */
	private List<CRM04Info> igalm0401List;
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 实时数据刷新频率 */
	protected String refreshRate;
	
	
	/**
	 * igalm0401List取得
	 *
	 * @return igalm0401List igalm0401List
	 */
	public List<CRM04Info> getIgalm0401List() {
		return igalm0401List;
	}
	/**
	 * igalm0401List设定
	 *
	 * @param igalm0401List igalm0401List
	 */
	public void setIgalm0401List(List<CRM04Info> igalm0401List) {
		this.igalm0401List = igalm0401List;
	}
	
	/**
	 * alarmPrioritiesStr取得
	 *
	 * @return alarmPrioritiesStr
	 */
	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}
	
	/**
	 * alarmPrioritiesStr设定
	 *
	 * @param String igalm0401List
	 */
	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}
	
	/**
	 * alarmPrioritiesList取得
	 *
	 * @return alarmPrioritiesList alarmPrioritiesList
	 */
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}
	
	/**
	 * alarmPrioritiesList设定
	 *
	 * @param List<CodeDetail> alarmPrioritiesList
	 */
	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	/**
	 * refreshRate取得
	 *
	 * @return refreshRate refreshRate
	 */
	public String getRefreshRate() {
		return refreshRate;
	}
	
	/**
	 * refreshRate设定
	 *
	 * @param String refreshRate
	 */
	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	/**
	 * checkedPrioritiesStr取得
	 *
	 * @return checkedPrioritiesStr checkedPrioritiesStr
	 */
	public String getCheckedPrioritiesStr() {
		return checkedPrioritiesStr;
	}	
	
	/**
	 * checkedPrioritiesStr设定
	 *
	 * @param String checkedPrioritiesStr
	 */
	public void setCheckedPrioritiesStr(String checkedPrioritiesStr) {
		this.checkedPrioritiesStr = checkedPrioritiesStr;
	}
	
	
}
