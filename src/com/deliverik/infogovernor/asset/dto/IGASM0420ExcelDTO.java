/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * ����: ��ͬ������Ϣ������DTO
 * ��������: ��ͬ������Ϣ������DTO
 * ������¼: 2012/04/19
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGASM0420ExcelDTO extends ExcelDTO {
	/** ������������  */
	private List<IG499Info> reportDataList;

	/**
	 * ������������ȡ��
	 *
	 * @return reportDataList ������������
	 */
	public List<IG499Info> getReportDataList() {
		return reportDataList;
	}

	/**
	 * �������������趨
	 *
	 * @param reportDataList ������������
	 */
	public void setReportDataList(List<IG499Info> reportDataList) {
		this.reportDataList = reportDataList;
	}
}
