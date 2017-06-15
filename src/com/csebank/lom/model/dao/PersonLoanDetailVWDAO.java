/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 人员借款统计DAO
 * 
 */
public interface PersonLoanDetailVWDAO extends BaseHibernateDAO<PersonLoanDetail> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PersonLoanDetail> findByCond(final PersonLoanDetailSearchCond cond,
			final int start, final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PersonLoanDetailSearchCond cond);
	
}
