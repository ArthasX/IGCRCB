package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产信息DAO接口
 * 
 */
public interface IG117DAO extends BaseHibernateDAO<IG117Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG117Info> findAll();

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public IG117Info findByPK(Serializable eid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG117SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG117Info> findByCond(final IG117SearchCond cond, final int start, final int count);
	
	public List<IG117Info> findByCond(final IG117SearchCond cond,final String id);
	public List<IG117Info> findByCondCoding(final IG117SearchCond cond);
}
