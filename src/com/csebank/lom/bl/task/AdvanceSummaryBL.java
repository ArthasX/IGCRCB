/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 预支汇总业务逻辑接口
 */
public interface AdvanceSummaryBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AdvanceSummarySearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param year 年度
	 * @param month 月份
	 * @return 预支汇总信息
	 */
	public AdvanceSummary searchAdvanceSummaryByKey(String year, String month) throws BLException;
	
	/**
	 * 本月预支汇总检索处理
	 * 
	 * @return 预支汇总信息
	 */
	public AdvanceSummary searchCurrentAdvanceSummary() throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceSummary> searchAdvanceSummary(AdvanceSummarySearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param AdvanceSummary 登录数据
	 * @return 值班预支汇总信息
	 */
	public AdvanceSummary registAdvanceSummary(AdvanceSummary advanceSummary) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param advanceSummary 变更数据
	 * @return 值班预支汇总信息
	 */
	public AdvanceSummary updateAdvanceSummary(AdvanceSummary advanceSummary) throws BLException;
	
	/**
	 * 预支新增处理
	 * 
	 * 本月预支金额 = 本月预支金额 + 输入预支金额
	 * 本月余额 = 本月余额 + 输入预支金额		
	 * 
	 * @param advanCescost 新增预支费用信息
	 */
	public void insertAdvanCescost(AdvanCescost advanCescost) throws BLException;
	
	/**
	 * 借款申请处理
	 * 
	 * 冻结金额 = 冻结金额 + 输入借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void loan(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 借款删除处理
	 * 
	 * 冻冻结金额 = 冻结金额 - 借款记录金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void deleteLoan(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 借款审批通过处理
	 * 
	 * 冻结金额 = 冻结金额 - 审批记录的借款金额		
	 * 借款金额 = 借款金额 + 审批记录的借款金额		
	 * 本月余额 = 本月余额 - 审批记录的借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void approveYes(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 借款审批不通过处理
	 * 
	 * 冻结金额 = 冻结金额 - 审批记录的借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void approveNo(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 还款确认处理,借款记录库存金额已更新
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 + 还款现金金额		
	 *       本月余额 = 本月余额 + 还款现金金额		
	 *       借款金额 = 借款金额 - 还款现金金额		
	 * 
	 * @param loanPayDetail 借款信息
	 * 
	 */
	public void payConfirm(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 新增还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 + 还款现金金额		
	 *       本月余额 = 本月余额 + 还款现金金额		
	 *       借款金额 = 借款金额 - 还款现金金额		
	 * 
	 * @param loanPayDetail 还款信息
	 * 
	 */
	public void addPayByCash(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 新增还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 
	 * 发票：本月发票额 = 本月发票额 + 还款发票额		
	 *       借款金额 = 借款金额 - 还款发票金额			
	 * 
	 * @param loanPayDetail 还款信息
	 */
	public void addPayByInvoice(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 删除还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 - 还款现金金额		
	 * 		本月余额 = 本月余额 - 还款现金金额		
	 * 		借款金额 = 借款金额 + 还款现金金额		
	 * 
	 * @param loanPayDetail 还款信息
	 * 
	 */
	public void delPayByCash(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 删除还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 
	 * 发票：本月发票额 = 本月发票额 - 还款发票额		
	 * 		 借款金额 = 借款金额 + 还款发票金额		
	 * 
	 * @param loanPayDetail 还款信息
	 */
	public void delPayByInvoice(LoanPayDetail loanPayDetail) throws BLException;
	
	/**
	 * 冲抵借款处理
	 * 
	 * 发票金额小于预支金额时，用库存金额冲抵	
	 * 
	 * @param advanCescost 预支信息
	 * 
	 */
	public void credit(AdvanCescost advanCescost) throws BLException;
	
	/**
	 * 可用金额取得
	 * 
	 * 可用金额 = 本月余额 - 冻结金额
	 * 
	 * @return 可用金额
	 */
	public BigDecimal searchAvailableAmount() throws BLException;
	
	/**
	 * 库存金额取得
	 * 
	 * 库存金额 = 本月余额	
	 * 
	 * @return 库存金额
	 */
	public BigDecimal searchStockAmount() throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceSummary> searchAdvanceSummaryByEmp(AdvancesummaryCond cond, int start, int count);

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AdvancesummaryCond cond);
}
