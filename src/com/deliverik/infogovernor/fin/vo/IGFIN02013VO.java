/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.model.Expense;


/**
 * IGFIN02013VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN02013VO extends BaseVO implements Serializable{
	

	protected Expense expenseData;


	public IGFIN02013VO(Expense expenseData) {
		this.expenseData = expenseData;
	}
	

	public Expense getExpenseData() {
		return expenseData;
	}

}


