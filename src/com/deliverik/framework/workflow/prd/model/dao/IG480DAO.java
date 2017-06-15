/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;

/**
  * 概述: 流程组定义表DAO接口
  * 功能描述: 流程组定义表DAO接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG480DAO extends BaseHibernateDAO<IG480Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG480Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG480Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG480SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG480Info> findByCond(
			final IG480SearchCond cond, final int start,
			final int count);

	/**
	 * PGDID主键值取得
	 * 
	 * @return PGDID主键值
	 */
	public String getPgdidSequenceNextValue(String firstsite,String pdsequence);
	/**
	 * 流程组定义升版处理
	 * 
	 * @param pgdid 流程组定义ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid);
	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyGroupProcessDefVersion(final String pgdid,final String pdsequence);
}