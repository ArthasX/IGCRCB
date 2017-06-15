/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 分组信息vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR05011VO extends BaseVO{

	/** 分组信息集合 */
	protected List<ReportHistoryVWInfo> reportHistoryVWInfoList;

	/**
	 * 分组信息集合取得
	 * @return reportHistoryVWInfoList 分组信息集合
	 */
	public List<ReportHistoryVWInfo> getReportHistoryVWInfoList() {
		return reportHistoryVWInfoList;
	}

	/**
	 * 分组信息集合设定
	 * @param reportHistoryVWInfoList 分组信息集合
	 */
	public void setReportHistoryVWInfoList(
			List<ReportHistoryVWInfo> reportHistoryVWInfoList) {
		this.reportHistoryVWInfoList = reportHistoryVWInfoList;
	}
	
}
