package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG160DAO;

/**
 * <p>
 * 流程相关人员汇总统计业务逻辑实现
 * </p>
 */
public class IG160BLImpl extends BaseBLImpl implements IG160BL{
	
	/**流程相关人员汇总统计操作*/
	protected IG160DAO ig160DAO;
	
	/**
	 * 设置流程相关人员汇总统计操作
	 * @param ig160DAO IG160DAO
	 */
	public void setIg160DAO(IG160DAO ig160DAO) {
		this.ig160DAO = ig160DAO;
	}

	/**
	 * 流程相关人员汇总统计
	 * 
	 * @return 流程相关人员汇总统计列表
	 */
	
	public List<IG160Info> searchIG160Info(final IG160SearchCond cond, final int start, final int count) {
		return ig160DAO.findByCond(cond, start, count);
	}

}
