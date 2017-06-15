/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
import com.deliverik.infogovernor.sym.model.dao.PriorityDAO;
/**
 * 概述:优先级BL实现类
 *功能描述：1.持久化处理
 * 			2.全件检索
 * 			3.条件检索结果件数取得
 * 			4.条件检索处理
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
public class PriorityBLImpl extends BaseBLImpl implements PriorityBL {
	
	protected PriorityDAO priorityDAO;
	

	public PriorityDAO getPriorityDAO() {
		return priorityDAO;
	}

	public void setPriorityDAO(PriorityDAO priorityDAO) {
		this.priorityDAO = priorityDAO;
	}

	/**
     * 持久化处理
     * @param priority 实体
     */
	public Priority savePriority(Priority priority) throws BLException{
		return priorityDAO.save(priority);
	}
	
	/**
     * 全件检索
     * @return 检索结果集
     */
	public List<Priority> findAllPriority() throws BLException{
		return priorityDAO.findAll();
	}
	
	/**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
	public int getSearchCount(PrioritySearchCond cond) throws BLException{
		return priorityDAO.getSearchCount(cond);
	}
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	public List<Priority> findByCond(PrioritySearchCond cond, int start, int count) throws BLException{
		return priorityDAO.findByCond(cond, start, count);
	}
}
