/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
/**
 * 虚拟化统计分析
 *
 */
public interface VIM03CountVWDAO extends BaseHibernateDAO<Integer> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond);
	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond);
}
