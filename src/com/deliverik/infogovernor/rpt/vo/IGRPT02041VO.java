/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;

/**
 * ����: 
 * ��������: 
 * ������¼: 2012/04/27
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02041VO extends BaseVO{
	
	protected List<SOC0205Info> reportManageList;

	/**
	 * reportManageListȡ��
	 *
	 * @return reportManageList reportManageList
	 */
	public List<SOC0205Info> getReportManageList() {
		return reportManageList;
	}

	/**
	 * reportManageList�趨
	 *
	 * @param reportManageList reportManageList
	 */
	public void setReportManageList(List<SOC0205Info> reportManageList) {
		this.reportManageList = reportManageList;
	}
}
