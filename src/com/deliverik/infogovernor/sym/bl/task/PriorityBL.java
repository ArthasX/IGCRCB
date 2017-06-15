/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
/**
 * 概述:优先级BL接口
 * 功能描述：1.持久化处理
 * 			2.全件检索
 * 			3.条件检索结果件数取得
 * 			4.条件检索处理
 * 			5.按主键查询
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */

public interface PriorityBL extends BaseBL{
	
	/**
     * 持久化处理
     * @param hacProcess 实体
     */
	public Priority savePriority(Priority priority) throws BLException;
	
	/**
     * 全件检索
     * @return 检索结果集
     */
	public List<Priority> findAllPriority() throws BLException;
	
	/**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
	public int getSearchCount(PrioritySearchCond cond) throws BLException;
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	public List<Priority> findByCond(PrioritySearchCond cond, int start, int count) throws BLException;
}
