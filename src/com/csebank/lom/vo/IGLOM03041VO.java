/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 借款审批、确认VO
 *
 */
public class IGLOM03041VO extends BaseVO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	/** 借款审批、确认检索结果 */
	protected List<LoanPayDetail> loanPayDetailList;

	/**
	 * 借款审批、确认取得
	 * @return 借款审批、确认
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * 借款审批、确认设定
	 * @param loanPayDetailList 借款审批、确认
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

}
