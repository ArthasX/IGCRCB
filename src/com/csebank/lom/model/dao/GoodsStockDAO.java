/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 库存统计DAO接口
 *
 */
public interface GoodsStockDAO extends BaseHibernateDAO<GoodsStock> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoodsStock> findByCond(final GoodsStockSearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<GoodsStock> getSearchCount(final GoodsStockSearchCond cond);
}
