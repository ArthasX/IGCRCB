/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.ram.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * ����: ����������Ϣ������DTO
 * ��������: ����������Ϣ������DTO
 * ������¼: 2013/06/20
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGRAM0301ExcelDTO extends ExcelDTO{
	/**����������Ϣ*/
	private List<String> orgReport;
	
	/**����������ѯ��ʼʱ��*/
	protected String propentime_from;
	
	/**����������ѯ����ʱ��*/
	protected String propentime_to;
	
	/**
	 * orgReportȡ��
	 */
	public List<String> getOrgReport() {
		return orgReport;
	}
	/**
	 * orgReport�趨
	 */
	public void setOrgReport(List<String> orgReport) {
		this.orgReport = orgReport;
	}
	/**
	 * propentime_fromȡ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}
	/**
	 * propentime_from�趨
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}
	/**
	 * propentime_toȡ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}
	/**
	 * propentime_to�趨
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

}
