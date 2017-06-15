/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * 概述: 合同付款信息导出用DTO
 * 功能描述: 合同付款信息导出用DTO
 * 创建记录: 2012/04/19
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGASM0420ExcelDTO extends ExcelDTO {
	/** 报表数据内容  */
	private List<IG499Info> reportDataList;

	/**
	 * 报表数据内容取得
	 *
	 * @return reportDataList 报表数据内容
	 */
	public List<IG499Info> getReportDataList() {
		return reportDataList;
	}

	/**
	 * 报表数据内容设定
	 *
	 * @param reportDataList 报表数据内容
	 */
	public void setReportDataList(List<IG499Info> reportDataList) {
		this.reportDataList = reportDataList;
	}
}
