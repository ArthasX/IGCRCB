/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCond;
import com.deliverik.infogovernor.smr.model.dao.FillInQualityAssessVWDAO;

/**
 * 概述:填报考核
 * 功能描述：填报考核
 * 创建人：赵梓廷
 * 创建记录： 2013-08-30
 * 修改记录：
 */
public class FillInQualityAssessVWBLImpl extends BaseBLImpl implements
		FillInQualityAssessVWBL {

	/** 填报考核DAO*/
	protected FillInQualityAssessVWDAO fillInQualityAssessVWDAO;
	
	/**
	 * 填报考核DAO设定
	 *
	 * @param fillInQualityAssessVWDAO 填报考核DAO
	 */
	public void setFillInQualityAssessVWDAO(
			FillInQualityAssessVWDAO fillInQualityAssessVWDAO) {
		this.fillInQualityAssessVWDAO = fillInQualityAssessVWDAO;
	}

	public List<FillInQualityAssessInfo> searchFillInQualityByUser(
			FillInQualityAssessSearchCond cond) {
		
		return fillInQualityAssessVWDAO.searchFillInQualityByUser(cond);
	}
	
	public List<ReportDetailVWInfo> searchListForDetailByUser(
			FillInQualityAssessSearchCond cond) {
		
		return fillInQualityAssessVWDAO.searchListForDetailByUser(cond);
	}


}
