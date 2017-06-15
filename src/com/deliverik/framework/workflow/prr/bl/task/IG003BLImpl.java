package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG003DAO;

/**
 * <p>
 * 流程年度汇总统计业务逻辑实现
 * </p>
 */
public class IG003BLImpl extends BaseBLImpl implements IG003BL{
	
	/**流程年度汇总统计操作*/
	protected IG003DAO ig003DAO;
	
	/**
	 * 设置流程年度汇总统计操作
	 * @param ig003DAO ProcessSummaryVWDAO
	 */
	public void setIg003DAO(IG003DAO ig003DAO) {
		this.ig003DAO = ig003DAO;
	}

	/**
	 * 流程年度汇总统计
	 * 
	 * @return 流程年度汇总统计列表
	 */
	
	public List<IG003Info> searchIG003Info(final IG003SearchCond cond, final int start, final int count) {
		return ig003DAO.findByCond(cond, start, count);
	}

}
