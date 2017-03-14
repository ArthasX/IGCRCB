/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * 检查问题统计业务逻辑接口
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;

public interface ProcessRecordSummaryVWBL {
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessRecordSummary> searchServiceProcessRecordRelation(ProcessRecordSummarySearchCond cond, int start, int count);
}
