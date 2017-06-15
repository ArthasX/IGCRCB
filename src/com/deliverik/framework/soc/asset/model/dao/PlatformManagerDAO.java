package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;



/**
 * 资产项关系信息DAO接口
 * 
 */
public interface PlatformManagerDAO extends BaseHibernateDAO<PlatformManagerInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<PlatformManagerInfo> findAll();

	/**
	 * 主键检索处理
	 * @param eirid 主键
	 * @return 检索结果
	 */
	public PlatformManagerInfo findByPK(Serializable eirid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PlatformManagerVWSearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PlatformManagerInfo> findByCond(final PlatformManagerVWSearchCond cond, final int start, final int count);
	
	
}
