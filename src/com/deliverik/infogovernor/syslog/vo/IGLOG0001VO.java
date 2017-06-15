/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
 * 设备日志告警实时显示
 * @author 王省
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0001VO extends BaseVO implements Serializable {
	
	/** 实时设备日志告警列表 */
	private List<Mss00005Info> sysLogAlarmList;
	
	/** 告警总数 */
	protected Integer totalcount;
	
	/** 设备实时告警信息列表(带流程) */
	protected List<IGLOG0003VO> list_vo;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	
	/** 刷新频率 */
	protected String refreshRate;
	
	
	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}


	public String getCheckedPrioritiesStr() {
		return checkedPrioritiesStr;
	}

	public void setCheckedPrioritiesStr(String checkedPrioritiesStr) {
		this.checkedPrioritiesStr = checkedPrioritiesStr;
	}

	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}

	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}
	
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	/**
	 * 实时设备日志告警列表取得
	 * @return
	 */
	public List<Mss00005Info> getSysLogAlarmList() {
		return sysLogAlarmList;
	}
	
	/**
	 * 实时设备日志告警列表设定
	 * @param sysLogAlarmList
	 */
	public void setSysLogAlarmList(List<Mss00005Info> sysLogAlarmList) {
		this.sysLogAlarmList = sysLogAlarmList;
	}

	/**
	 * 告警总数取得
	 */
	public Integer getTotalcount() {
		return totalcount;
	}

	/**
	 * 告警总数设定
	 */
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
		/**
	 * 设备实时告警信息列表(带流程)取得
	 */
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	/**
	 * 设备实时告警信息列表(带流程)设定
	 */
	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}
	
	

}
