/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.ram.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * 概述: 年度评估信息导出用DTO
 * 功能描述: 年度评估信息导出用DTO
 * 创建记录: 2013/06/20
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGRAM0401ExcelDTO extends ExcelDTO{
	/**部门评估信息*/
	private List<String> yearReport;
	
	/**年度评估差条件*/
	protected String currentyear;

	/**
	 * currentyear取得
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear设定
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}
	/**
	 * yearReport取得
	 */
	public List<String> getYearReport() {
		return yearReport;
	}
	/**
	 * yearReport设定
	 */
	public void setYearReport(List<String> yearReport) {
		this.yearReport = yearReport;
	}

}
