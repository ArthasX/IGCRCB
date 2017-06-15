/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 借还款明细DAO接口
 *
 */
public interface LoanPayDetailDAO extends BaseHibernateDAO<LoanPayDetail> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<LoanPayDetail> findAll();

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public LoanPayDetail findByPK(Serializable lpdid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final LoanPayDetailSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<LoanPayDetail> findByCond(final LoanPayDetailSearchCond cond, final int start, final int count);
	
	/**
	 * 获取已还款现金数和已还款发票数
	 * 
	 * @param lpdid 借款记录ID
	 * @return 已还款现金数和已还款发票数
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(final Integer lpdid);
}
