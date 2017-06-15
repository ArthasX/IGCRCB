/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.csebank.lom.model.dao.LoanPayDetailDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 借还款明细业务逻辑接口实现
 */
public class LoanPayDetailBLImpl extends BaseBLImpl implements LoanPayDetailBL {
	
	/** LoanPayDetail DAO */
	protected LoanPayDetailDAO loanPayDetailDAO;
	
	public void setLoanPayDetailDAO(
			LoanPayDetailDAO loanPayDetailDAO) {
		this.loanPayDetailDAO = loanPayDetailDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(LoanPayDetailSearchCond cond){
		
		return loanPayDetailDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param lpdid 借还款明细ID
	 * @return 借还款明细ID
	 */
	public LoanPayDetail searchLoanPayDetailByKey(Integer lpdid) throws BLException{
		
		return checkExistLoanPayDetail(lpdid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部借还款明细信息
	 */
	public List<LoanPayDetail> searchLoanPayDetailAll(){
		
		return loanPayDetailDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<LoanPayDetail> searchLoanPayDetail(LoanPayDetailSearchCond cond, int start, int count){
		
		return loanPayDetailDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param loanPayDetail 登录数据
	 * @return 借还款明细信息
	 */
	public LoanPayDetail registLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException{
		
		return loanPayDetailDAO.save(loanPayDetail);
	}

	/**
	 * 删除处理
	 * 
	 * @param lpdid 借还款明细ID
	 * @return
	 */
	public void deleteLoanPayDetail(Integer lpdid) throws BLException{
		
		LoanPayDetail loanPayDetail = checkExistLoanPayDetail(lpdid);
		
		loanPayDetailDAO.delete(loanPayDetail);
	}

	/**
	 * 变更处理
	 * 
	 * @param loanPayDetail 变更数据
	 * @return 借还款明细信息
	 */
	public LoanPayDetail updateLoanPayDetail(LoanPayDetail loanPayDetail) throws BLException{
		
		checkExistLoanPayDetail(loanPayDetail.getLpdid());
		return loanPayDetailDAO.save(loanPayDetail);
	}

	/**
	 * 借还款明细信息存在检查
	 * 
	 * @param lpdid 借还款明细ID
	 * @return 借还款明细信息
	 * @throws BLException 
	 */
	protected LoanPayDetail checkExistLoanPayDetail(Integer lpdid) throws BLException{
		LoanPayDetail info = loanPayDetailDAO.findByPK(lpdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","借还款明细基本");
		}
		return info;
	}
	
	/**
	 * 获取已还款现金数和已还款发票数
	 * 
	 * @param lpdid 借款记录ID
	 * @return 已还款现金数和已还款发票数
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(Integer lpdid) {
		return loanPayDetailDAO.searchAmountdAndInvoice(lpdid);
	}

}
