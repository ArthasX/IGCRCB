/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.soc.cim.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * ����: �ʲ��Զ�����Ϣ������DTO
 * ��������: �ʲ��Զ�����Ϣ������DTO
 * ������¼: 2013/12/27
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGCIM1102ExcelDTO extends ExcelDTO{
	
	/** �ʲ��Զ��屨��Ԥ����ͷ */
	protected  Map<String,List<String>> titleListMap;
	
	/** ������title */
	protected String reportTitle;
	
	/** �ʲ��Զ��屨��Ԥ������ */
	protected  Map<String,List<String[]>> contentListMap;
	
	public Map<String, List<String>> getTitleListMap() {
		return titleListMap;
	}

	public void setTitleListMap(Map<String, List<String>> titleListMap) {
		this.titleListMap = titleListMap;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Map<String, List<String[]>> getContentListMap() {
		return contentListMap;
	}

	public void setContentListMap(Map<String, List<String[]>> contentListMap) {
		this.contentListMap = contentListMap;
	}
}
