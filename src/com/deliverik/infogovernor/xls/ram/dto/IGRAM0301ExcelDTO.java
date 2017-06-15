/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.ram.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
/**
 * 
 * 概述: 部门评估信息导出用DTO
 * 功能描述: 部门评估信息导出用DTO
 * 创建记录: 2013/06/20
 * 修改记录:
 */
@SuppressWarnings("serial")
public class IGRAM0301ExcelDTO extends ExcelDTO{
	/**部门评估信息*/
	private List<String> orgReport;
	
	/**部门评估查询开始时间*/
	protected String propentime_from;
	
	/**部门评估查询结束时间*/
	protected String propentime_to;
	
	/**
	 * orgReport取得
	 */
	public List<String> getOrgReport() {
		return orgReport;
	}
	/**
	 * orgReport设定
	 */
	public void setOrgReport(List<String> orgReport) {
		this.orgReport = orgReport;
	}
	/**
	 * propentime_from取得
	 */
	public String getPropentime_from() {
		return propentime_from;
	}
	/**
	 * propentime_from设定
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}
	/**
	 * propentime_to取得
	 */
	public String getPropentime_to() {
		return propentime_to;
	}
	/**
	 * propentime_to设定
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

}
