/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 接待管理DAO接口
 *
 */
public interface RecptionAmountDAO extends BaseHibernateDAO<RecptionAmount> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionAmount> findByCond(final RecptionSearchCond cond, final int start, final int count);
	

}
