/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fin.model.Budget;

/**
 * Ԥ����ϸ��ʾ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGFIN01021VO extends BaseVO implements Serializable{
	
	/** Ԥ����ϸ��ʾ��Ϣ */
	protected Budget budgetData;
	
	protected String bstatus;
	
	

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	/**
	 * ���캯��
	 * @param processRecordData��Ԥ����ϸ��ʾ��Ϣ
	 */
	public IGFIN01021VO(Budget budgetData) {
		this.budgetData = budgetData;
	}
	
	/**
	 * Ԥ����ϸ��ʾ��Ϣȡ��
	 * @return Ԥ����ϸ��ʾ��Ϣ
	 */
	public Budget getBudgetData() {
		return budgetData;
	}
}


