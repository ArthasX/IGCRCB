/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.csebank.lom.model.dao.RecptionVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 接待汇总业务逻辑接口实现
 */
public class RecptionVWBLImpl extends BaseBLImpl implements RecptionVWBL {
	
	/** RecptionVW DAO */
	protected RecptionVWDAO recptionVWDAO;
	
	public void setRecptionVWDAO(
			RecptionVWDAO recptionVWDAO) {
		this.recptionVWDAO = recptionVWDAO;
	}

	public List<RecptionVWInfo> searchRecptionVW(RecptionVWSearchCond cond,
			int start, int count) {
		
		return recptionVWDAO.findByCond(cond, start, count);
	}

}
