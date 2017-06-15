/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 2012/04/27
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02001VO extends BaseVO{
	
	/** 自定义报表 性能 */
	protected List<SOC0204Info> reportCustomLinkList_Pref;
	
	/** 自定义报表 容量 */
	protected List<SOC0204Info> reportCustomLinkList_Cap;

	/**
	 * 自定义报表性能取得
	 *
	 * @return reportCustomLinkList_Pref 自定义报表性能
	 */
	public List<SOC0204Info> getReportCustomLinkList_Pref() {
		return reportCustomLinkList_Pref;
	}

	/**
	 * 自定义报表容量取得
	 *
	 * @return reportCustomLinkList_Cap 自定义报表容量
	 */
	public List<SOC0204Info> getReportCustomLinkList_Cap() {
		return reportCustomLinkList_Cap;
	}

	/**
	 * 自定义报表性能设定
	 *
	 * @param reportCustomLinkList_Pref 自定义报表性能
	 */
	public void setReportCustomLinkList_Pref(
			List<SOC0204Info> reportCustomLinkList_Pref) {
		this.reportCustomLinkList_Pref = reportCustomLinkList_Pref;
	}

	/**
	 * 自定义报表容量设定
	 *
	 * @param reportCustomLinkList_Cap 自定义报表容量
	 */
	public void setReportCustomLinkList_Cap(
			List<SOC0204Info> reportCustomLinkList_Cap) {
		this.reportCustomLinkList_Cap = reportCustomLinkList_Cap;
	}
}
