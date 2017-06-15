/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
 * 历史设备日志告警显示
 * @author 王省
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0002VO extends BaseVO implements Serializable {
	
	/** 历史设备日志告警列表 */
	private List<Mss00005Info> historySysLogAlarmList;
	
	/** 告警总数 */
	protected Integer totalcount; 
	
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	
	protected String checkedPrioritiesStr;
	
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
	/**
	 * 历史设备日志告警列表取得
	 * @return
	 */
	public List<Mss00005Info> getHistorySysLogAlarmList() {
		return historySysLogAlarmList;
	}
	
	/**
	 * 历史设备日志告警列表设定
	 * @param historySysLogAlarmList
	 */
	public void setHistorySysLogAlarmList(List<Mss00005Info> historySysLogAlarmList) {
		this.historySysLogAlarmList = historySysLogAlarmList;
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
	
}
