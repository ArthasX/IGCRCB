/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;

/**
 * ����汾��Ϣ��������֣�
 * 
 */
@SuppressWarnings("serial")
public class IGSYM04121VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected ReportFileDefinition reportFileDefinition;
	
	/** ����汾��Ϣ��������� */
	protected List<ReportFileVersion> reportFileVersionList;

	/**
	 * ���캯��
	 * @param reportFileDefinition ������Ϣ
	 * @param reportFileVersionList��������Ϣ���������
	 */
	public IGSYM04121VO(ReportFileDefinition reportFileDefinition, List<ReportFileVersion> reportFileVersionList) {
		this.reportFileDefinition = reportFileDefinition;
		this.reportFileVersionList = reportFileVersionList;
	}
	
	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}
	
	
	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

}


