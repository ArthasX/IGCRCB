/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.util.List;
import java.util.Map;

public class IGFIN01012VO {

	private Map<Integer, List> budgetIdExpenseListMap;
	private Map<Integer, String> budgetIdNameMap;

	public Map<Integer, List> getBudgetIdExpenseListMap() {
		return budgetIdExpenseListMap;
	}

	public void setBudgetIdExpenseListMap(
			Map<Integer, List> budgetIdExpenseListMap) {
		this.budgetIdExpenseListMap = budgetIdExpenseListMap;
	}

	public Map<Integer, String> getBudgetIdNameMap() {
		return budgetIdNameMap;
	}

	public void setBudgetIdNameMap(Map<Integer, String> budgetIdNameMap) {
		this.budgetIdNameMap = budgetIdNameMap;
	}

}
