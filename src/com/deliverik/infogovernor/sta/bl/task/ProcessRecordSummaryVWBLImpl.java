package com.deliverik.infogovernor.sta.bl.task;
/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;
import com.deliverik.infogovernor.sta.model.dao.ProcessRecordSummaryVWDAO;

/**
 * <p>
 * 检查问题统计业务逻辑实现
 * </p>
 */

public class ProcessRecordSummaryVWBLImpl  extends BaseBLImpl implements ProcessRecordSummaryVWBL{
	
	/**
	 * 注入ProcessRecordSummaryVWDAO
	 */
	
	protected ProcessRecordSummaryVWDAO processRecordSummaryVWDAO;
	
	/**
	 * 设置processRecordSummaryVWDAO
	 * 
	 * @param processRecordSummaryVWDAO
	 *            processRecordSummaryVWDAO
	 */
	public void setProcessRecordSummaryVWDAO(
			ProcessRecordSummaryVWDAO processRecordSummaryVWDAO) {
		this.processRecordSummaryVWDAO = processRecordSummaryVWDAO;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessRecordSummary> searchServiceProcessRecordRelation(ProcessRecordSummarySearchCond cond, int start, int count){
		
		return processRecordSummaryVWDAO.findByCond(cond, start, count);
		
	}

}
