/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;

/**
 * ����: 
 * ��������: 
 * ������¼: 2012/04/27
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02011VO extends BaseVO{
	
	
	protected List<SOC0206Info> reportTemplateMappingList;
	
	protected List<MonitorObjectInfo> monitorObjectList;
	
	protected List<SOC0207Info> reportTemplateList;

	/**
	 * reportTemplateListȡ��
	 *
	 * @return reportTemplateList reportTemplateList
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}

	/**
	 * reportTemplateList�趨
	 *
	 * @param reportTemplateList reportTemplateList
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}

	/**
	 * monitorObjectListȡ��
	 *
	 * @return monitorObjectList monitorObjectList
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * monitorObjectList�趨
	 *
	 * @param monitorObjectList monitorObjectList
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * reportTemplateMappingListȡ��
	 *
	 * @return reportTemplateMappingList reportTemplateMappingList
	 */
	public List<SOC0206Info> getReportTemplateMappingList() {
		return reportTemplateMappingList;
	}

	/**
	 * reportTemplateMappingList�趨
	 *
	 * @param reportTemplateMappingList reportTemplateMappingList
	 */
	public void setReportTemplateMappingList(
			List<SOC0206Info> reportTemplateMappingList) {
		this.reportTemplateMappingList = reportTemplateMappingList;
	}
}
