/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;

/**
 * 报表版本信息检索结果ＶＯ
 * 
 */
@SuppressWarnings("serial")
public class IGSYM04121VO extends BaseVO implements Serializable{
	
	/** 报表信息 */
	protected ReportFileDefinition reportFileDefinition;
	
	/** 报表版本信息检索结果集 */
	protected List<ReportFileVersion> reportFileVersionList;

	/**
	 * 构造函数
	 * @param reportFileDefinition 报表信息
	 * @param reportFileVersionList　报表信息检索结果集
	 */
	public IGSYM04121VO(ReportFileDefinition reportFileDefinition, List<ReportFileVersion> reportFileVersionList) {
		this.reportFileDefinition = reportFileDefinition;
		this.reportFileVersionList = reportFileVersionList;
	}
	
	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}
	
	
	/**
	 * 报表信息取得
	 * @return 报表信息
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

}


