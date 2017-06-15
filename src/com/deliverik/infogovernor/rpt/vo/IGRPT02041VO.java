/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 2012/04/27
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02041VO extends BaseVO{
	
	protected List<SOC0205Info> reportManageList;

	/**
	 * reportManageList取得
	 *
	 * @return reportManageList reportManageList
	 */
	public List<SOC0205Info> getReportManageList() {
		return reportManageList;
	}

	/**
	 * reportManageList设定
	 *
	 * @param reportManageList reportManageList
	 */
	public void setReportManageList(List<SOC0205Info> reportManageList) {
		this.reportManageList = reportManageList;
	}
}
