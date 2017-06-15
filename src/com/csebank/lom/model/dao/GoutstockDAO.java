/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 物品出库信息DAO接口
 *
 */
public interface GoutstockDAO extends BaseHibernateDAO<Goutstock> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Goutstock> findAll();

	/**
	 * 主键检索处理
	 * @param rid 主键
	 * @return 检索结果
	 */
	public Goutstock findByPK(Serializable goid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GoutstockSearchCond cond);
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goutstock> findByCond(final GoutstockSearchCond cond, final int start, final int count);

	
}
