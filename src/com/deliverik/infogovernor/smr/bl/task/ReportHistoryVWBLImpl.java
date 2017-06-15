/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCond;
import com.deliverik.infogovernor.smr.model.dao.ReportHistoryVWDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportHistoryVWBLImpl implements ReportHistoryVWBL{

	/** 报表历史填报记录视图 */
	protected ReportHistoryVWDAO reportHistoryVWDAO;

	/**
	 * 报表历史填报记录视图设定
	 * @param reportHistoryVWDAO 报表历史填报记录视图
	 */
	public void setReportHistoryVWDAO(ReportHistoryVWDAO reportHistoryVWDAO) {
		this.reportHistoryVWDAO = reportHistoryVWDAO;
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<ReportHistoryVWInfo> searchReportHistoryVWInfoList(ReportHistoryVWSearchCond cond){
		return reportHistoryVWDAO.findByCond(cond);
	}
}
