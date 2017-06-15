/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.model.Budget;

/**
 * 预算详细显示信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN01021VO extends BaseVO implements Serializable{
	
	/** 预算详细显示信息 */
	protected Budget budgetData;
	
	protected String bstatus;
	
	

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	/**
	 * 构造函数
	 * @param processRecordData　预算详细显示信息
	 */
	public IGFIN01021VO(Budget budgetData) {
		this.budgetData = budgetData;
	}
	
	/**
	 * 预算详细显示信息取得
	 * @return 预算详细显示信息
	 */
	public Budget getBudgetData() {
		return budgetData;
	}
}


