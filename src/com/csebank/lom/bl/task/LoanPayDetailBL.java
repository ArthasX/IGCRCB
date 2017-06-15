/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 借还款明细业务逻辑接口
 */
public interface LoanPayDetailBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(LoanPayDetailSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param lpdid 借还款明细ID
	 * @return 借还款明细ID
	 */
	public LoanPayDetail searchLoanPayDetailByKey(Integer lpdid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部借还款明细信息
	 */
	public List<LoanPayDetail> searchLoanPayDetailAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<LoanPayDetail> searchLoanPayDetail(LoanPayDetailSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param LoanPayDetail 登录数据
	 * @return 借还款明细信息
	 */
	public LoanPayDetail registLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param lpdid 借还款明细ID
	 * @throws BLException
	 */
	public void deleteLoanPayDetail(Integer lpdid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param loanPayDetail 变更数据
	 * @return 借还款明细信息
	 */
	public LoanPayDetail updateLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 获取已还款现金数和已还款发票数
	 * 
	 * @param lpdid 借款记录ID
	 * @return 已还款现金数和已还款发票数
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(Integer lpdid);

}
