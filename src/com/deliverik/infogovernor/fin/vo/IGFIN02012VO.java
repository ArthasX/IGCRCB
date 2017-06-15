/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.model.Expense;


/**
 * IGFIN01011VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN02012VO extends BaseVO implements Serializable{
	

	protected List<Expense> expenseDataList;


	public IGFIN02012VO(List<Expense> expenseDataList) {
		this.expenseDataList = expenseDataList;
	}
	

	public List<Expense> getExpenseDataList() {
		return expenseDataList;
	}

}


