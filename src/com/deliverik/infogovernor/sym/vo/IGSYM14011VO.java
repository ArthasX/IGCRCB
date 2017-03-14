/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ������Ϣ��������֣�
 * 
 */
@SuppressWarnings("serial")
public class IGSYM14011VO extends BaseVO implements Serializable{
	
	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;

	/**
	 * ���캯��
	 * @param reportFileDefinitionList��������Ϣ���������
	 */
	public IGSYM14011VO(List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}
	
	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}
	
	
}


