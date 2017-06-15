/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 报表信息检索结果ＶＯ
 * 
 */
@SuppressWarnings("serial")
public class IGCOM02151VO extends BaseVO implements Serializable{
	
	/** BIRT报表文件路径 */
	protected String reporturl;
	
	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** 节点完整名称 */
	protected String completeNodeName;

	/**
	 * 构造函数
	 * @param reportFileDefinitionList　报表信息检索结果集
	 * @param completeNodeName 节点完成名称
	 */
	public IGCOM02151VO(List<ReportFileDefinition> reportFileDefinitionList, String completeNodeName) {
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		reporturl = ctlBL.getCodeValue(CodeDefinition.BIRT, "", "", CodeDefinition.BIRT_URL);
		this.reportFileDefinitionList = reportFileDefinitionList;
		this.completeNodeName = completeNodeName;
	}
	
	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * BIRT报表文件路径取得
	 * @return BIRT报表文件路径
	 */
	public String getReporturl() {
		return reporturl;
	}
	
	/**
	 * 节点完成名称取得
	 * @return 节点完成名称
	 */
	public String getCompleteNodeName() {
		return completeNodeName;
	}

}


