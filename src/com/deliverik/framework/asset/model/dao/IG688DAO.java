package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 资产项视图DAO接口
 * 
 * @author 
 */
public interface IG688DAO extends BaseHibernateDAO<IG688Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG688SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG688Info> findByCond(final IG688SearchCond cond, final int start, final int count);
}
