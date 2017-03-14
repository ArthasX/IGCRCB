/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCond;

/**
 * 概述:填报考核
 * 功能描述：填报考核
 * 创建人：赵梓廷
 * 创建记录： 2013-08-30
 * 修改记录：
 */
public interface FillInQualityAssessVWBL extends BaseBL{

	/**
	 * 按人员查询
	 *
	 * @return 检索结果集
	 */
	public List<FillInQualityAssessInfo> searchFillInQualityByUser(final FillInQualityAssessSearchCond cond);
	
	/**
	 * 查询(监管报表详细页)
	 *
	 * @return 检索结果集
	 */
	public List<ReportDetailVWInfo> searchListForDetailByUser(final FillInQualityAssessSearchCond cond);
	
}
