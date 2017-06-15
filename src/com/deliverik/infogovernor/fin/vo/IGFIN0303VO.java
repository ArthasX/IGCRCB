/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.util.List;

import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;

public class IGFIN0303VO {
	
	private static final long serialVersionUID = 1L;
	
	private List<Expense> expenseList;
	private List<Budget> budgetList;
	private String index;
	private String bType;
	private int sumBudget;
	private double sumBMoney;
	private int sumExpense;
	private double sumExMoney;
	
	
	public double getSumBMoney() {
		return sumBMoney;
	}
	public double getSumExMoney() {
		return sumExMoney;
	}
	public void setSumBMoney(double sumBMoney) {
		this.sumBMoney = sumBMoney;
	}
	public void setSumExMoney(double sumExMoney) {
		this.sumExMoney = sumExMoney;
	}
	public List<Expense> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}
	public List<Budget> getBudgetList() {
		return budgetList;
	}
	public void setBudgetList(List<Budget> budgetList) {
		this.budgetList = budgetList;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getBType() {
		return bType;
	}
	public void setBType(String type) {
		bType = type;
	}
	public int getSumBudget() {
		return sumBudget;
	}
	public void setSumBudget(int sumBudget) {
		this.sumBudget = sumBudget;
	}
	
	public int getSumExpense() {
		return sumExpense;
	}
	public void setSumExpense(int sumExpense) {
		this.sumExpense = sumExpense;
	}
	
}
