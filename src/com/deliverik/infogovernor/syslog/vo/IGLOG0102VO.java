/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;

/**
 * 历史设备日志显示
 * @author 王省
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0102VO extends BaseVO implements Serializable {
	
	/** 历史设备日志列表 */
	private List historySysLogList;

	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	protected List<CodeDetail>ruleli=null;
	
	protected List<IGLOG0003VO> list_vo;
	
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}

	public List<CodeDetail> getRuleli() {
		return ruleli;
	}

	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}

	protected String checkedPrioritiesStr;
	
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
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
	
	/**
	 * 历史设备日志列表取得
	 * @return
	 */
	public List getHistorySysLogList() {
		return historySysLogList;
	}
	
	/**
	 * 历史设备日志列表设定
	 * @param historySysLogList
	 */
	public void setHistorySysLogList(List historySysLogList) {
		this.historySysLogList = historySysLogList;
	}
	
}
