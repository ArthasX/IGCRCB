package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;

/**
 * 数据分类信息DAO接口
 * 
 */
public interface CodeCategoryTBDAO extends BaseHibernateDAO<CodeCategoryInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<CodeCategoryInfo> findAll();

	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CodeCategoryInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CodeCategorySearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CodeCategoryInfo> findByCond(final CodeCategorySearchCond cond, final int start, final int count);

}
