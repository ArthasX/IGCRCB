/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 2012/04/27
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02011VO extends BaseVO{
	
	
	protected List<SOC0206Info> reportTemplateMappingList;
	
	protected List<MonitorObjectInfo> monitorObjectList;
	
	protected List<SOC0207Info> reportTemplateList;

	/**
	 * reportTemplateList取得
	 *
	 * @return reportTemplateList reportTemplateList
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}

	/**
	 * reportTemplateList设定
	 *
	 * @param reportTemplateList reportTemplateList
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}

	/**
	 * monitorObjectList取得
	 *
	 * @return monitorObjectList monitorObjectList
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * monitorObjectList设定
	 *
	 * @param monitorObjectList monitorObjectList
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * reportTemplateMappingList取得
	 *
	 * @return reportTemplateMappingList reportTemplateMappingList
	 */
	public List<SOC0206Info> getReportTemplateMappingList() {
		return reportTemplateMappingList;
	}

	/**
	 * reportTemplateMappingList设定
	 *
	 * @param reportTemplateMappingList reportTemplateMappingList
	 */
	public void setReportTemplateMappingList(
			List<SOC0206Info> reportTemplateMappingList) {
		this.reportTemplateMappingList = reportTemplateMappingList;
	}
}
