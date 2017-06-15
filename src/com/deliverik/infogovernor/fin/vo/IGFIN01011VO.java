/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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

	/** ������Ŀ�Ǽ�ҳ��Ԥ�㼯�ϵ���ʾ*/
	private List<IGFIN0102Form> budgetLeaveAmountList;
	
	/** Ԥ����ʾ�б���б����ֱ���ж�Ԥ�����Ƿ�����Ŀ*/
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
	 * ��ȡbudgetFormList
	 * @return fbudgetFormList budgetFormList
	 */
	public List<IGFIN0102Form> getBudgetFormList() {
		return budgetFormList;
	}

	/**
	 * ����budgetFormList
	 * @param budgetFormList  budgetFormList
	 */
	public void setBudgetFormList(List<IGFIN0102Form> budgetFormList) {
		this.budgetFormList = budgetFormList;
	}

}


