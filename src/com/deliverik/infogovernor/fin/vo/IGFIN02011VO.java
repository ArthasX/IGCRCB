/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.model.Budget;


/**
 * IGFIN01011VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN02011VO extends BaseVO implements Serializable{
	

	protected List<Budget> budgetDataList;


	public IGFIN02011VO(List<Budget> budgetDataList) {
		this.budgetDataList = budgetDataList;
	}
	

	public List<Budget> getBudgetDataList() {
		return budgetDataList;
	}

}


