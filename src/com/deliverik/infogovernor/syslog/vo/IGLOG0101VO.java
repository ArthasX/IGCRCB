/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;

/**
 * 设备日志实时显示
 * @author 王省
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0101VO extends BaseVO implements Serializable {
	
	/** 实时设备日志列表 */
	private List<Mss00008Info> sysLogList;
	
	/** 告警级别列表(字符串形式) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	/** 告警级别列表 */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** 实时数据刷新频率 */
	protected String refreshRate;
	
	/** 设备实时告警信息列表(带流程) */
	protected List<IGLOG0003VO> list_vo;
	
	/** 实时syslog实体 */
	protected Mss00008Info syslogbean;
	
	/** 告警总数 */
	protected Integer totalcount;
	
	/** 运维人员 */
	protected String isMaintain;
	
	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}


	public Mss00008Info getSyslogbean() {
		return syslogbean;
	}

	public void setSyslogbean(Mss00008Info syslogbean) {
		this.syslogbean = syslogbean;
	}
	
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}

	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	
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
	 * 实时设备日志列表取得
	 * @return
	 */
	public List<Mss00008Info> getSysLogList() {
		return sysLogList;
	}
	
	/**
	 * 实时设备日志列表设定
	 * @param sysLogList
	 */
	public void setSysLogList(List<Mss00008Info> sysLogList) {
		this.sysLogList = sysLogList;
	}

	/**
	 * 运维人员标识取得
	 *
	 * @return isMaintain 运维人员
	 */
	public String getIsMaintain() {
		return isMaintain;
	}
	
	/**
	 * 运维人员设定
	 *
	 * @param isMaintain 运维人员
	 */
	public void setIsMaintain(String isMaintain) {
		this.isMaintain = isMaintain;
	}
	
}
