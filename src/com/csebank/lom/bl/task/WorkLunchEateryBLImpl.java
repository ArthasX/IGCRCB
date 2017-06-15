/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.csebank.lom.model.dao.WorkLunchEateryDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂成本信息业务逻辑接口实现
 */
public class WorkLunchEateryBLImpl extends BaseBLImpl implements WorkLunchEateryBL {
	
	/** WorkLunchEatery DAO */
	protected WorkLunchEateryDAO workLunchEateryDAO;
	
	public void setWorkLunchEateryDAO(
			WorkLunchEateryDAO workLunchEateryDAO) {
		this.workLunchEateryDAO = workLunchEateryDAO;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkLunchEatery> searchWorkLunchEatery(WorkLunchEaterySearchCond cond, int start, int count){
		
		return workLunchEateryDAO.findByCond(cond,start,count);
	}

}
