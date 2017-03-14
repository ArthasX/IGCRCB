/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;

/**
 * <P>概述:流程评审操作业务逻辑接口</p>
 * <p>功能描述：1.关闭或终止流程取得</p>
 * <p>创建记录：songhy 20101129</p>
 */

public interface IG433BL extends BaseBL {

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */	
	public List<IG567Info> searchIG567Info(IG433SearchCond cond, int start, int count);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */	
	public IG433Info findIG567Info(IG433SearchCond cond, int start, int count);
	
	/**
	 * 功能：持久化处理
	 * 
	 * @param IncomeAdjust实体类
	 * @return IncomeAdjust实体类
	 */
	public IG433Info saveIG567Info(IG433Info processAssessment)
			throws BLException;
}
