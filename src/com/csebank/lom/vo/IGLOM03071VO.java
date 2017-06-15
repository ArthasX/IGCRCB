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
 * 冲抵计财部借款VO
 *
 */
public class IGLOM03071VO extends BaseVO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	/** 冲抵计财部借款检索结果 */
	protected List<LoanPayDetail> loanPayDetailList;

	/**
	 * 冲抵计财部借款取得
	 * @return 冲抵计财部借款
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * 冲抵计财部借款设定
	 * @param loanPayDetailList 冲抵计财部借款
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

}
