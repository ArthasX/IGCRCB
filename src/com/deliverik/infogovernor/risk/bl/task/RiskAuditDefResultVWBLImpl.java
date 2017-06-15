/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditDefResultVWDAO;

/**
 * 
 * 审计项和相关审计人外联视图业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditDefResultVWBLImpl extends BaseBLImpl implements RiskAuditDefResultVWBL{
	
	/** RiskAuditDefResultVW DAO */
	protected RiskAuditDefResultVWDAO RiskAuditDefResultVWDAO;
	
	public void setRiskAuditDefResultVWDAO(
			RiskAuditDefResultVWDAO RiskAuditDefResultVWDAO) {
		this.RiskAuditDefResultVWDAO = RiskAuditDefResultVWDAO;
	}


	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditDefResultVWInfo> searchRiskAuditDefResultVW(RiskAuditDefResultVWSearchCond cond, int start, int count){
		
		return RiskAuditDefResultVWDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 获取审计项最大级次
	 * @return 审计项最大级次
	 */
	public String getMaxRadlevel(RiskAuditDefResultVWSearchCond cond){
		return RiskAuditDefResultVWDAO.getMaxRadlevel(cond);
	}
	
}
