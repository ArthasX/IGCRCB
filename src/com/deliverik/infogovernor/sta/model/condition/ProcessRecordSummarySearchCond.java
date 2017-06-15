/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * 检查问题统计查询条件接口
 */
public interface ProcessRecordSummarySearchCond {
	
	/**
	 * 问题种类取得
	 * @return 问题种类
	 */	
	public String getPcode();
	
	/**
	 * 问题来源取得
	 * @return 问题来源
	 */
	public String getPrassetname();
	
	/**
	 * 问题整改发起日期form取得
	 * @return 问题整改发起日期form
	 */	
	public String getPropentime_from();
	
	/**
	 * 问题整改发起日期to取得
	 * @return 问题整改发起日期to
	 */	
	public String getPropentime_to();
	
	/**
	 * 统计类型取得
	 * @return 统计类型
	 */	
	public String getStatistictype();

}
