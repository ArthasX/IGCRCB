package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 机柜视图DAO接口
 * 
 * @author 
 */
public interface IG778DAO extends BaseHibernateDAO<IG778Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG778SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG778Info> findByCond(final IG778SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG778Info> findByIG778Info(final IG778SearchCond cond);
}
