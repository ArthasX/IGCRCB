/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
/**
 * 
 * 概述: 合同付款信息导出用DTO
 * 功能描述: 合同付款信息导出用DTO
 * 创建记录: 2012/04/19
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGASM0404ExcelDTO extends ExcelDTO {
	
	/** 导出表头部分信息 */
	protected List<SOC0600Info> exportInfoList;
	
	/** 导出应付款列表信息 */
	protected List<SOC0600Info> exportInfoPayList;

	/**
	 * 导出表头部分信息取得
	 * @return 导出表头部分信息
	 */
	public List<SOC0600Info> getExportInfoList() {
		return exportInfoList;
	}

	/**
	 * 导出表头部分信息设定
	 * @param exportInfoList 导出表头部分信息
	 */
	public void setExportInfoList(List<SOC0600Info> exportInfoList) {
		this.exportInfoList = exportInfoList;
	}

	/**
	 * 导出应付款列表信息取得
	 * @return 导出应付款列表信息
	 */
	public List<SOC0600Info> getExportInfoPayList() {
		return exportInfoPayList;
	}

	/**
	 * 导出应付款列表信息设定
	 * @param exportInfoPayList 导出应付款列表信息
	 */
	public void setExportInfoPayList(List<SOC0600Info> exportInfoPayList) {
		this.exportInfoPayList = exportInfoPayList;
	}
}
