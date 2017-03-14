/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;
import com.deliverik.infogovernor.svc.model.dao.AnnualTrendVWDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计BL实现
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class AnnualTrendVWBLImpl extends BaseBLImpl implements AnnualTrendVWBL{

	/** 年度工作趋势统计DAO */
	protected AnnualTrendVWDAO annualTrendVWDAO;

	/**
	 * 年度工作趋势统计DAO设定
	 * @param incidentTypeDAO 年度工作趋势统计DAO
	 */
	public void setAnnualTrendVWDAO(AnnualTrendVWDAO annualTrendVWDAO) {
		this.annualTrendVWDAO = annualTrendVWDAO;
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchIncidentTypeData(AnnualTrendVWSearchCond cond){
		return annualTrendVWDAO.searchAnnualTrendVW(cond);
	}
}
