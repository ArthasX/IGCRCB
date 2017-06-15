/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.bl.task.ExpenseBL;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;

public class IGFIN05BLImpl extends BaseBLImpl implements IGFIN05BL {
	
	//protected BudgetTBDAO budgetTBDAO;
	
	//protected ExpenseTBDAO expenseTBDAO;

	protected BudgetBL budgetBL;

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}
     
    protected ExpenseBL expenseBL;
	
	

	public void setExpenseBL(ExpenseBL expenseBL) {
		this.expenseBL = expenseBL;
	}

	/** 获取所有预算金额 */
	protected Float getSumBudget() throws BLException {
		Float allBudget = 0f;
		List<Budget> allBudgetList = this.budgetBL.findAll();
		for (Budget budget : allBudgetList) {
			allBudget += Float.parseFloat(String.valueOf(budget.getBamount()));
		}
		return allBudget;
	}

	/** 获取所有费用金额 */
	protected Float getSumExpense() throws BLException {
		Float allExpense = 0f;
		List<Expense> allExpenseList = this.expenseBL.findAll();
		for (Expense expense : allExpenseList) {
			allExpense += Float.parseFloat(String.valueOf(expense.getExamount()));
		}
		return allExpense;
	}

	public String getDataXml() throws BLException {
		StringBuilder xmlSB = new StringBuilder();
		xmlSB.append("<chart palette='3' animation='1' lowerLimit='0' upperLimit='10' showBorder='0' showShadow='1' caption='' " +
				"colorRangeFillRatio='0,10,80,10' showColorRangeBorder='0' subcaption='RMB(万)' " +
				"roundRadius='0' numberPrefix='' numberSuffix='万' showValue='0'>");
		xmlSB.append("<value>");
		xmlSB.append(this.getSumExpense()/10000);
		xmlSB.append("</value><target>");
		xmlSB.append(this.getSumBudget()/10000);
		xmlSB.append("</target>");
		xmlSB.append("</chart>");
		return xmlSB.toString();
	}
}
