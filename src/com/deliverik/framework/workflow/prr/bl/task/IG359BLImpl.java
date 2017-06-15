package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG359DAO;

/**
 * <p>
 * 相关资产流程统计汇总统计业务逻辑实现
 * </p>
 */
public class IG359BLImpl extends BaseBLImpl implements IG359BL{
	
	/**相关资产流程统计汇总统计操作*/
	protected IG359DAO ig359DAO;
	
	/**
	 * 设置相关资产流程统计汇总统计操作
	 * @param ig359DAO Ig359DAO
	 */
	public void setIg359DAO(IG359DAO ig359DAO) {
		this.ig359DAO = ig359DAO;
	}

	/**
	 * 相关资产流程统计汇总统计
	 * 
	 * @return 相关资产流程统计汇总统计列表
	 */
	
	public List<IG359Info> searchIG359Info(final IG359SearchCond cond, final int start, final int count) {
		return ig359DAO.findByCond(cond, start, count);
	}

}
