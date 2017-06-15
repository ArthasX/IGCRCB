/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.CurrentMonthWorkVWDAO;

/**
 * 概述:查询带有处理人的本月工作 
 * 功能描述：查询带有处理人的本月工作
 * 创建人：赵梓廷
 * 创建记录： 2013-04-22
 * 修改记录：
 */
public class CurrentMonthWorkVWBLImpl extends BaseBLImpl implements
		CurrentMonthWorkVWBL {

	/** 查询带有当前处理人的本月工作DAO接口 */
	protected CurrentMonthWorkVWDAO  currentMonthWorkVWDAO;
	
	/**
	 * 查询带有当前处理人的本月工作DAO接口设定
	 *
	 * @param currentMonthWorkVWDAO 查询带有当前处理人的本月工作DAO接口
	 */
	public void setCurrentMonthWorkVWDAO(CurrentMonthWorkVWDAO currentMonthWorkVWDAO) {
		this.currentMonthWorkVWDAO = currentMonthWorkVWDAO;
	}

	/**
	 * 本月工作检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCurrentMonthWorkCount(CurrentMonthWorkVWSearchCond cond) {
		
		return currentMonthWorkVWDAO.getSearchCurrentMonthWorkCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CurrentMonthWorkVWInfo> findCurrentMonthWorkByCond(
			CurrentMonthWorkVWSearchCond cond, int start, int count) {
		
		return currentMonthWorkVWDAO.findCurrentMonthWorkByCond(cond, start, count);
	}

}
