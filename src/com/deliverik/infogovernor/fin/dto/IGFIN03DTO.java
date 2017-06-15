/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.fin.form.IGFIN0301Form;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;



/**
 *预算用DTO
 * 
 */
public class IGFIN03DTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = 5218672401326640896L;

	protected BudgetSearchCond budgetSearchCond;
	
	protected List budgetList;
	
	protected ExpenseSearchCond expenseSearchCond;
	
	protected IGFIN0301Form igfin0301Form;
	
	protected List expenseList;
	

	protected List<LabelValueBean> byearList;//预算年份集合
	
	public List<LabelValueBean> getByearList() {
		return byearList;
	}

	public void setByearList(List<LabelValueBean> byearList) {
		this.byearList = byearList;
	}
	
	public BudgetSearchCond getBudgetSearchCond() {
		return budgetSearchCond;
	}

	public void setBudgetSearchCond(BudgetSearchCond budgetSearchCond) {
		this.budgetSearchCond = budgetSearchCond;
	}

	public List getBudgetList() {
		return budgetList;
	}

	public void setBudgetList(List budgetList) {
		this.budgetList = budgetList;
	}

	public ExpenseSearchCond getExpenseSearchCond() {
		return expenseSearchCond;
	}

	public void setExpenseSearchCond(ExpenseSearchCond expenseSearchCond) {
		this.expenseSearchCond = expenseSearchCond;
	}

	public IGFIN0301Form getIgfin0301Form() {
		return igfin0301Form;
	}

	public void setIgfin0301Form(IGFIN0301Form igfin0301Form) {
		this.igfin0301Form = igfin0301Form;
	}

	public List getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List expenseList) {
		this.expenseList = expenseList;
	}

}


