/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 报表信息检索结果ＶＯ
 * 
 */
@SuppressWarnings("serial")
public class IGSYM04091VO extends BaseVO implements Serializable{
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;

	/**
	 * 构造函数
	 * @param reportFileDefinitionList　报表信息检索结果集
	 */
	public IGSYM04091VO(List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}
	
	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}
	
	
}


