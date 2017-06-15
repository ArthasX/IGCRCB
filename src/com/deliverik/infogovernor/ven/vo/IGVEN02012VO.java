/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;

@SuppressWarnings("serial")
public class IGVEN02012VO extends BaseVO implements Serializable{
	
	/** 风险监测表接口  */	
	protected RiskMonitoringInfo riskMonitoringInfo;
	/** 监测工作填报表接口   */	
	protected MonitoringWorkInfo monitoringWorkInfo;
	/** 附件id  */	
	protected Integer attid;
	/** 附件名  */	
	protected String attname;
	
	
	
	
	/**
	 * 附件id取得
	 * @return attid  附件id
	 */
	public Integer getAttid() {
		return attid;
	}
	/**
	 * 附件id设定
	 * @param attid  附件id
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}
	/**
	 * 附件名取得
	 * @return attname  附件名
	 */
	public String getAttname() {
		return attname;
	}
	/**
	 * 附件名设定
	 * @param attname  附件名
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
	/**
	 * riskMonitoringInfo取得
	 * @return riskMonitoringInfo  riskMonitoringInfo
	 */
	public RiskMonitoringInfo getRiskMonitoringInfo() {
		return riskMonitoringInfo;
	}
	/**
	 * riskMonitoringInfo设定
	 * @param riskMonitoringInfo  riskMonitoringInfo
	 */
	public void setRiskMonitoringInfo(RiskMonitoringInfo riskMonitoringInfo) {
		this.riskMonitoringInfo = riskMonitoringInfo;
	}
	/**
	 * 监测工作填报表接口取得
	 * @return monitoringWorkInfo  监测工作填报表接口
	 */
	public MonitoringWorkInfo getMonitoringWorkInfo() {
		return monitoringWorkInfo;
	}
	/**
	 * 监测工作填报表接口设定
	 * @param monitoringWorkInfo  监测工作填报表接口
	 */
	public void setMonitoringWorkInfo(MonitoringWorkInfo monitoringWorkInfo) {
		this.monitoringWorkInfo = monitoringWorkInfo;
	}
	
}
