/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.rpt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ������Ϣ��������֣�
 * 
 */
@SuppressWarnings("serial")
public class IGRPT01021VO extends BaseVO implements Serializable{
	
	/** BIRT�����ļ�·�� */
	protected String reporturl;
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	protected List<ReportFileDefinition> selectedReportFileDefinitionList;
	
	public List<ReportFileDefinition> getSelectedReportFileDefinitionList() {
		return selectedReportFileDefinitionList;
	}

	public void setSelectedReportFileDefinitionList(
			List<ReportFileDefinition> selectedReportFileDefinitionList) {
		this.selectedReportFileDefinitionList = selectedReportFileDefinitionList;
	}

	/** �ڵ��������� */
	protected String completeNodeName;

	/**
	 * ���캯��
	 * @param reportFileDefinitionList��������Ϣ���������
	 * @param completeNodeName �ڵ��������
	 */
	public IGRPT01021VO(List<ReportFileDefinition> reportFileDefinitionList, String completeNodeName) {
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		reporturl = ctlBL.getCodeValue(CodeDefinition.BIRT, "", "", CodeDefinition.BIRT_URL);
		this.reportFileDefinitionList = reportFileDefinitionList;
		this.completeNodeName = completeNodeName;
	}
	
	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * BIRT�����ļ�·��ȡ��
	 * @return BIRT�����ļ�·��
	 */
	public String getReporturl() {
		return reporturl;
	}
	
	/**
	 * �ڵ��������ȡ��
	 * @return �ڵ��������
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

}


