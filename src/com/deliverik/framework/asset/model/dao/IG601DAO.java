package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 机房视图DAO接口
 * 
 * @author 
 */
public interface IG601DAO extends BaseHibernateDAO<IG601Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG601SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG601Info> findByCond(final IG601SearchCond cond, final int start, final int count);
}
