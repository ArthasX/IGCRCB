/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 还款登记管理VO
 *
 */
public class IGLOM03131VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** 还款登记搜索结果集 */
	protected List<LoanPayDetail> loanPayDetailList;
	
	/** 还款登记信息 */
	protected LoanPayDetail loanPayDetailData;
	
	/** 还款总额 */
	protected BigDecimal[] db;

	/**
	 * 还款登记搜索结果集取得
	 * @return 还款登记搜索结果集
	 */
	public List<LoanPayDetail> getLoanPayDetailList() {
		return loanPayDetailList;
	}

	/**
	 * 还款登记搜索结果集设定
	 * @param loanPayDetailList 还款登记搜索结果集
	 */
	public void setLoanPayDetailList(List<LoanPayDetail> loanPayDetailList) {
		this.loanPayDetailList = loanPayDetailList;
	}

	/**
	 * 还款登记信息取得
	 * @return 还款登记信息
	 */
	public LoanPayDetail getLoanPayDetailData() {
		return loanPayDetailData;
	}

	/**
	 * 还款登记信息设定
	 * @param loanPayDetailData 还款登记信息
	 */
	public void setLoanPayDetailData(LoanPayDetail loanPayDetailData) {
		this.loanPayDetailData = loanPayDetailData;
	}

	/**
	 * 还款总额取得
	 * @return 还款总额
	 */
	public BigDecimal[] getDb() {
		return db;
	}

	/**
	 * 还款总额设定
	 * @param db 还款总额
	 */
	public void setDb(BigDecimal[] db) {
		this.db = db;
	}

}
