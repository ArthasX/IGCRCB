/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.csebank.lom.model.dao.DealOrgVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 部门接待汇总业务逻辑接口实现
 */
public class DealOrgVWBLImpl extends BaseBLImpl implements DealOrgVWBL {
	
	/** RecptionOrgVW DAO */
	protected DealOrgVWDAO dealOrgVWDAO;
	
	

	public List<DealOrg> searchDealOrgVW(DealOrgVWSearchCond cond,
			int start, int count) {
		
		return dealOrgVWDAO.findByCond(cond, start, count);
	}



	public DealOrgVWDAO getDealOrgVWDAO() {
		return dealOrgVWDAO;
	}



	public void setDealOrgVWDAO(DealOrgVWDAO dealOrgVWDAO) {
		this.dealOrgVWDAO = dealOrgVWDAO;
	}
	
}
