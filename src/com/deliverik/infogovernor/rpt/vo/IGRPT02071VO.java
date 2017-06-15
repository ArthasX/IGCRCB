/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;

/**
 * ����: ���ӱ���VO
 * ��������: 
 * ������¼: ����ȫ 2012/06/14
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02071VO extends BaseVO{
	/**��������*/
	private String reportName;
	
	/**���Ӽ���*/
	private List<SOC0202Info> reportAnnexationList=new ArrayList<SOC0202Info>();

	/**
	 * ���Ӽ���ȡ��
	 *
	 * @return reportAnnexationList ���Ӽ���
	 */
	public List<SOC0202Info> getReportAnnexationList() {
		return reportAnnexationList;
	}

	/**
	 * ���Ӽ����趨
	 *
	 * @param reportAnnexationList ���Ӽ���
	 */
	public void setReportAnnexationList(
			List<SOC0202Info> reportAnnexationList) {
		this.reportAnnexationList = reportAnnexationList;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return reportName ��������
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * ���������趨
	 *
	 * @param reportName ��������
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	
}
