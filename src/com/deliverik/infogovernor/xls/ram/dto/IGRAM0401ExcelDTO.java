/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.ram.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * ����: ���������Ϣ������DTO
 * ��������: ���������Ϣ������DTO
 * ������¼: 2013/06/20
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGRAM0401ExcelDTO extends ExcelDTO{
	/**����������Ϣ*/
	private List<String> yearReport;
	
	/**�������������*/
	protected String currentyear;

	/**
	 * currentyearȡ��
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear�趨
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}
	/**
	 * yearReportȡ��
	 */
	public List<String> getYearReport() {
		return yearReport;
	}
	/**
	 * yearReport�趨
	 */
	public void setYearReport(List<String> yearReport) {
		this.yearReport = yearReport;
	}

}
