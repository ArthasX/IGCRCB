package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产项关系信息DAO接口
 * 
 */
public interface IG313DAO extends BaseHibernateDAO<IG313Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG313Info> findAll();

	/**
	 * 主键检索处理
	 * @param eirid 主键
	 * @return 检索结果
	 */
	public IG313Info findByPK(Serializable eirid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG313SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG313Info> findByCond(final IG313SearchCond cond, final int start, final int count);
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG313Info> searchMaxIG313Info(final IG313SearchCond cond);
	
}
