/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;

/**
 * 概述: 附加报表VO
 * 功能描述: 
 * 创建记录: 杨龙全 2012/06/14
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02071VO extends BaseVO{
	/**报告名字*/
	private String reportName;
	
	/**附加集合*/
	private List<SOC0202Info> reportAnnexationList=new ArrayList<SOC0202Info>();

	/**
	 * 附加集合取得
	 *
	 * @return reportAnnexationList 附加集合
	 */
	public List<SOC0202Info> getReportAnnexationList() {
		return reportAnnexationList;
	}

	/**
	 * 附加集合设定
	 *
	 * @param reportAnnexationList 附加集合
	 */
	public void setReportAnnexationList(
			List<SOC0202Info> reportAnnexationList) {
		this.reportAnnexationList = reportAnnexationList;
	}

	/**
	 * 报告名字取得
	 *
	 * @return reportName 报告名字
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * 报告名字设定
	 *
	 * @param reportName 报告名字
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	
}
