/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 工作餐成本统计业务逻辑接口
 */
public interface WorkLunchEateryBL extends BaseBL {
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkLunchEatery> searchWorkLunchEatery(WorkLunchEaterySearchCond cond, int start, int count);

}
