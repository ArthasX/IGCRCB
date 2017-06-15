/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 资产关系图文件信息DAO接口
 *
 */
public interface IG809DAO extends BaseHibernateDAO<IG809Info>{
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG809Info> findAll();

	/**
	 * 主键检索处理
	 * @param eirfid 主键
	 * @return 检索结果
	 */
	public IG809Info findByPK(Serializable eirfid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG809SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG809Info> findByCond(final IG809SearchCond cond, final int start, final int count);

}
