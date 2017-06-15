/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * 接待汇总业务逻辑接口
 */
public interface RecptionVWBL extends BaseBL {
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionVWInfo> searchRecptionVW(RecptionVWSearchCond cond, int start, int count);
	
	
}
