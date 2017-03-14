/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * 检查问题统计查询条件实现
 */
public class ProcessRecordSummarySearchCondImpl implements ProcessRecordSummarySearchCond{
	
	/** 统计类型 */
	protected String statistictype;
	
	/** 问题种类 */
	protected String pcode;
	
	/** 问题来源 */
	protected String prassetname;
	
	/** 问题整改发起日期form */
	protected String propentime_from;
	
	/** 问题整改发起日期to*/
	protected String propentime_to;
	
	/**流程记录类型*/
	protected String prtype;
	
	/**
	 * 问题种类取得
	 * @return 问题种类
	 */	
	public String getPcode() {
		return pcode;
	}

	/**
	 * 问题种类设定
	 * @param pcode 问题种类
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 问题来源取得
	 * @return 问题来源
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 问题来源设定
	 * @param prassetname 问题来源
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * 问题整改发起日期form取得
	 * @return 问题整改发起日期form
	 */	
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 问题整改发起日期form设定
	 * @param propentime_from 问题整改发起日期form
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 问题整改发起日期to取得
	 * @return 问题整改发起日期to
	 */	
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 问题整改发起日期to设定
	 * @param propentime_to 问题整改发起日期to
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程记录类型设定
	 * @param prtype 流程记录类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 统计类型取得
	 * @return 统计类型
	 */	
	public String getStatistictype() {
		return statistictype;
	}

	/**
	 * 统计类型设定
	 * @param statistictype 统计类型
	 */
	public void setStatistictype(String statistictype) {
		this.statistictype = statistictype;
	}
}
