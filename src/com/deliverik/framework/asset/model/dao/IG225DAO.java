package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产配置信息DAO接口
 * 
 */
public interface IG225DAO extends BaseHibernateDAO<IG225Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG225Info> findAll();

	/**
	 * 主键检索处理
	 * @param cid 主键
	 * @return 检索结果
	 */
	public IG225Info findByPK(Serializable cid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG225SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG225Info> findByCond(final IG225SearchCond cond, final int start, final int count);
}
