/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 预支人员统计DAO
 * 
 */
public interface AdvanceDetailVWDAO extends BaseHibernateDAO<AdvanceDetail> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceDetail> findByCond(final AdvanceDetailSearchCond cond,
			final int start, final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvanceDetailSearchCond cond);

}
