/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.bl.task.ExpenseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCondImpl;
import com.deliverik.infogovernor.fin.vo.IGFIN0303VO;

public class IGFIN04BLImpl extends BaseBLImpl implements IGFIN04BL {
	
//	protected BudgetTBDAO budgetTBDAO;
//	
//	protected ExpenseTBDAO expenseTBDAO;

	protected BudgetBL budgetBL;

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}
     
    protected ExpenseBL expenseBL;
	
	

	public void setExpenseBL(ExpenseBL expenseBL) {
		this.expenseBL = expenseBL;
	}

	public IGFIN02DTO findCountByBudget(IGFIN02DTO dto) throws BLException {
		
		BudgetSearchCond cond = dto.getBudgetSearchCond();
		List<Budget> budgetList = this.budgetBL.findByCond(cond, 0, 0);
		Map<String,List<Budget>> typeBudgetMap = new HashMap<String,List<Budget>>();
		for (Budget budget : budgetList) {
			String btype = budget.getBtype();
			if(typeBudgetMap.containsKey(btype)){
				List<Budget> budgetInList = typeBudgetMap.get(btype);
				budgetInList.add(budget);
			} else {
				List<Budget> budgetInList = new ArrayList<Budget>();
				budgetInList.add(budget);
				typeBudgetMap.put(btype, budgetInList);
			}
		}
		IGFIN0303VO[] vos = new IGFIN0303VO[typeBudgetMap.size()];
		Iterator<String> budgetTypeIt = typeBudgetMap.keySet().iterator();
		
		int index = 0;
		while(budgetTypeIt.hasNext()){
			IGFIN0303VO vo = new IGFIN0303VO();
			String btype = budgetTypeIt.next();
			vo.setBType(btype);
			List<Budget> budgetInList = typeBudgetMap.get(btype);
			vo.setSumBudget(budgetInList.size());
			float sumBMoney = 0;
			float sumExMoney = 0;
			int sumExpense = 0;
			for (Budget budget : budgetInList) {
				sumBMoney += budget.getBamount();
				ExpenseSearchCondImpl expenseCond = new ExpenseSearchCondImpl();
				expenseCond.setBid(budget.getBid());
				List<Expense> expenseList = this.expenseBL.findByCond(expenseCond, 0, 0);
				for (Expense expense2 : expenseList) {
					sumExMoney += expense2.getExamount();
					sumExpense++;
				}
			}
			vo.setSumBMoney(sumBMoney);
			vo.setSumExpense(sumExpense);
			vo.setSumExMoney(sumExMoney);
			vos[index] = vo;
			index++;
		}
		dto.setVos(vos);
		return dto;
	}
	
	public IGFIN02DTO findBudgetByBType(IGFIN02DTO dto) throws BLException {
		BudgetSearchCond cond = dto.getBudgetSearchCond();
		List<Budget> budgetList = this.budgetBL.findByCond(cond, 0, 0);
		dto.setBudgetList(budgetList);
		return dto;
	}

	public IGFIN02DTO findExpenseByBType(IGFIN02DTO dto) throws BLException {
		BudgetSearchCond cond = dto.getBudgetSearchCond();
		List<Budget> budgetList = this.budgetBL.findByCond(cond, 0, 0);
		Set<Integer> bidSet = new HashSet<Integer>();
		for (Budget budget : budgetList) {
			bidSet.add(budget.getBid());
		}
		Iterator<Integer> bidIt = bidSet.iterator();
		List<Expense> allExpenseList = new ArrayList<Expense>();
		while(bidIt.hasNext()){
			ExpenseSearchCondImpl expenseCond = new ExpenseSearchCondImpl();
			expenseCond.setBid(bidIt.next());
			List<Expense> expenseList = this.expenseBL.findByCond(expenseCond, 0, 0);
			allExpenseList.addAll(expenseList);
		}
		dto.setExpenseList(allExpenseList);
		return dto;
	}
	
	public IGFIN02DTO findCountByExpense(IGFIN02DTO dto) throws BLException {
		String btype = dto.getBtype();
		ExpenseSearchCond cond = dto.getExpenseSearchCond();
		List<Expense> expenseList = this.expenseBL.findByCond(cond, 0, 0);
		List<Integer> exidList = new ArrayList<Integer>();
		Set<Integer> bidSet = new HashSet<Integer>();
		IGFIN0303VO[] vos = null;
		for (Expense expense : expenseList) {
			Integer bid = expense.getBid();
			exidList.add(expense.getExid());
			bidSet.add(bid);
		}
		Iterator<Integer> bidIt = bidSet.iterator();
		Map<String,List<Budget>> typeBudgetMap = new HashMap<String,List<Budget>>();
		while(bidIt.hasNext()){
			Integer bid = bidIt.next();
			Budget budget = this.budgetBL.findByPK(bid);
			if(budget == null){
				continue;
			}
			String type = budget.getBtype();
			if(null != btype && !"".equals(btype) && !type.equals(btype)){
				continue;
			}
			if(typeBudgetMap.containsKey(type)){
				List<Budget> budgetList = typeBudgetMap.get(type);
				budgetList.add(budget);
			} else {
				List<Budget> budgetList = new ArrayList<Budget>();
				budgetList.add(budget);
				typeBudgetMap.put(type, budgetList);
			}
		}
		Iterator<String> budgetTypeIt = typeBudgetMap.keySet().iterator();
		vos = new IGFIN0303VO[typeBudgetMap.size()];
		int index = 0;
		while(budgetTypeIt.hasNext()){
			IGFIN0303VO vo = new IGFIN0303VO();
			String budgetType = budgetTypeIt.next();
			List<Budget> budgetList = typeBudgetMap.get(budgetType);
			float sumBMoney = 0;
			float sumExMoney = 0;
			int sumExpense = 0;
			for (Budget budget1 : budgetList) {
				sumBMoney += budget1.getBamount();
				ExpenseSearchCondImpl expenseCond = new ExpenseSearchCondImpl();
				expenseCond.setBid(budget1.getBid());
				List<Expense> expenseInList = this.expenseBL.findByCond(expenseCond, 0, 0);
				for (Expense expense2 : expenseInList) {
					if(exidList.contains(expense2.getExid())){
						sumExMoney += expense2.getExamount();
						sumExpense++;
					}
				}
			}
			vo.setSumBudget(budgetList.size());
			vo.setBType(budgetType);
			vo.setSumBMoney(sumBMoney);
			vo.setSumExpense(sumExpense);
			vo.setSumExMoney(sumExMoney);
			vos[index] = vo;
			index++;
		}
		dto.setVos(vos);
		return dto;
	}

	public IGFIN02DTO findBudgetByExpense(IGFIN02DTO dto) throws BLException {
		String btype = dto.getBtype();
		ExpenseSearchCond cond = dto.getExpenseSearchCond();
		List<Expense> expenseList = this.expenseBL.findByCond(cond, 0, 0);
		List<Integer> exidList = new ArrayList<Integer>();
		Set<Integer> bidSet = new HashSet<Integer>();
		for (Expense expense : expenseList) {
			Integer bid = expense.getBid();
			exidList.add(expense.getExid());
			bidSet.add(bid);
		}
		Iterator<Integer> bidIt = bidSet.iterator();
		List<Budget> budgetList = new ArrayList<Budget>();
		while(bidIt.hasNext()){
			Integer bid = bidIt.next();
			Budget budget = this.budgetBL.findByPK(bid);
			if(budget == null){
				continue;
			}
			String type = budget.getBtype();
			if(btype.equals(type)){
				budgetList.add(budget);
			}
		}
		dto.setBudgetList(budgetList);
		return dto;
	}

	public IGFIN02DTO findExpenseByExpense(IGFIN02DTO dto) throws BLException {
		String btype = dto.getBtype();
		ExpenseSearchCond cond = dto.getExpenseSearchCond();
		List<Expense> expenseList = this.expenseBL.findByCond(cond, 0, 0);
		List<Integer> exidList = new ArrayList<Integer>();
		Set<Integer> bidSet = new HashSet<Integer>();
		for (Expense expense : expenseList) {
			Integer bid = expense.getBid();
			exidList.add(expense.getExid());
			bidSet.add(bid);
		}
		Iterator<Integer> bidIt = bidSet.iterator();
		List<Budget> budgetList = new ArrayList<Budget>();
		List<Expense> allExpenseList = new ArrayList<Expense>();
		while(bidIt.hasNext()){
			Integer bid = bidIt.next();
			Budget budget = this.budgetBL.findByPK(bid);
			if(budget == null){
				continue;
			}
			String type = budget.getBtype();
			if(btype.equals(type)){
				budgetList.add(budget);
			}
		}
		for (Budget budget : budgetList) {
			ExpenseSearchCondImpl expenseCond = new ExpenseSearchCondImpl();
			expenseCond.setBid(budget.getBid());
			List<Expense> expenseInList = this.expenseBL.findByCond(expenseCond, 0, 0);
			for (Expense expense2 : expenseInList) {
				if(exidList.contains(expense2.getExid())){
					allExpenseList.add(expense2);
				}
			}
		}
		dto.setExpenseList(allExpenseList);
		return dto;
	}

}
