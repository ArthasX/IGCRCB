/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;

/**
  * 概述: 流程组实例表DAO接口
  * 功能描述: 流程组实例表DAO接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG483DAO extends BaseHibernateDAO<IG483Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG483Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG483Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG483SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG483Info> findByCond(
			final IG483SearchCond cond, final int start,
			final int count);
	
	/**
	 * 查询当前默认最大流水号（WG+2位年+6位流水）
	 * @param pgrserialnum 流水号
	 * @return 最大流水号
	 */
	public String getMaxPgrserialnum(final String pgrserialnum);
	
	/**
	 * 查询流程组成员列表
	 * @param pgrid 流程组ID
	 * @return 流程组成员列表
	 */
	public List<IG500Info> searchProcess(final Integer pgrid);
	
	/**
	 * 查询流程组外发起的流程prid
	 * @param pgrid 检索条件-流程组实例ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid);

}