/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;

@SuppressWarnings("serial")
public class IGVEN02012VO extends BaseVO implements Serializable{
	
	/** ���ռ���ӿ�  */	
	protected RiskMonitoringInfo riskMonitoringInfo;
	/** ��⹤�����ӿ�   */	
	protected MonitoringWorkInfo monitoringWorkInfo;
	/** ����id  */	
	protected Integer attid;
	/** ������  */	
	protected String attname;
	
	
	
	
	/**
	 * ����idȡ��
	 * @return attid  ����id
	 */
	public Integer getAttid() {
		return attid;
	}
	/**
	 * ����id�趨
	 * @param attid  ����id
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}
	/**
	 * ������ȡ��
	 * @return attname  ������
	 */
	public String getAttname() {
		return attname;
	}
	/**
	 * �������趨
	 * @param attname  ������
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
	/**
	 * riskMonitoringInfoȡ��
	 * @return riskMonitoringInfo  riskMonitoringInfo
	 */
	public RiskMonitoringInfo getRiskMonitoringInfo() {
		return riskMonitoringInfo;
	}
	/**
	 * riskMonitoringInfo�趨
	 * @param riskMonitoringInfo  riskMonitoringInfo
	 */
	public void setRiskMonitoringInfo(RiskMonitoringInfo riskMonitoringInfo) {
		this.riskMonitoringInfo = riskMonitoringInfo;
	}
	/**
	 * ��⹤�����ӿ�ȡ��
	 * @return monitoringWorkInfo  ��⹤�����ӿ�
	 */
	public MonitoringWorkInfo getMonitoringWorkInfo() {
		return monitoringWorkInfo;
	}
	/**
	 * ��⹤�����ӿ��趨
	 * @param monitoringWorkInfo  ��⹤�����ӿ�
	 */
	public void setMonitoringWorkInfo(MonitoringWorkInfo monitoringWorkInfo) {
		this.monitoringWorkInfo = monitoringWorkInfo;
	}
	
}
