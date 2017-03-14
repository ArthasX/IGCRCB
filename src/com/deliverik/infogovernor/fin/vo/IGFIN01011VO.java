/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.model.Budget;


/**
 * IGFIN01011VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN01011VO extends BaseVO implements Serializable{
	

	protected List<Budget> budgetDataList;

	/** 用于项目登记页面预算集合的显示*/
	private List<IGFIN0102Form> budgetLeaveAmountList;
	
	/** 预算显示列表此列表可以直接判断预算下是否有项目*/
	private List<IGFIN0102Form> budgetFormList;
	
	public IGFIN01011VO(List<Budget> budgetDataList) {
		this.budgetDataList = budgetDataList;
	}
	
	public IGFIN01011VO() {
	}

	public List<IGFIN0102Form> getBudgetLeaveAmountList() {
		return budgetLeaveAmountList;
	}


	public void setBudgetLeaveAmountList(List<IGFIN0102Form> budgetLeaveAmountList) {
		this.budgetLeaveAmountList = budgetLeaveAmountList;
	}


	public List<Budget> getBudgetDataList() {
		return budgetDataList;
	}

	/**
	 * 获取budgetFormList
	 * @return fbudgetFormList budgetFormList
	 */
	public List<IGFIN0102Form> getBudgetFormList() {
		return budgetFormList;
	}

	/**
	 * 设置budgetFormList
	 * @param budgetFormList  budgetFormList
	 */
	public void setBudgetFormList(List<IGFIN0102Form> budgetFormList) {
		this.budgetFormList = budgetFormList;
	}

}


