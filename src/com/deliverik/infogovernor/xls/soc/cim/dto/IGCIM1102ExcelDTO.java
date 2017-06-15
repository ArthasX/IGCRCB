/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.soc.cim.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * 概述: 资产自定义信息导出用DTO
 * 功能描述: 资产自定义信息导出用DTO
 * 创建记录: 2013/12/27
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGCIM1102ExcelDTO extends ExcelDTO{
	
	/** 资产自定义报表预览表头 */
	protected  Map<String,List<String>> titleListMap;
	
	/** 报表定义title */
	protected String reportTitle;
	
	/** 资产自定义报表预览内容 */
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
