/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * 概述: 流程组关联关系实例表DAO接口
  * 功能描述: 流程组关联关系实例表DAO接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG485DAO extends BaseHibernateDAO<IG485Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG485Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG485Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG485SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG485Info> findByCond(
			final IG485SearchCond cond, final int start,
			final int count);
	
	/**
	 * 根据指定流程和状态，查询流程组关系实例表中，
	 * 该流程的参考流程和参考状态的记录
	 * @param pgrid 流程组ID
	 * @param pgdid 流程组定义ID
	 * @param ipsdid 影响状态ID
	 * @return 参考流程列表
	 */
	public List<Object[]> checkPend(final Integer pgrid, final String pgdid, final String ipsdid);
	
	/**
	 * 根据指定流程组和状态，查询状态相关的挂起流程中，
	 * @param pgrid 流程组实例ID
	 * @param ipsdid 影响状态ID
	 * @return 影响流程ID列表
	 */
	public List<IG224VW> searchPendPrid(final Integer pgrid, final String ipsdid);
	
	/**
	 * 查询关联关系实例未处理记录
	 * @param prid 参考流程ID
	 * @param rpsdid 参考流程状态ID
	 * @return 未处理记录
	 */
	public List<IG485VW> searchNotDone(final Integer prid, final String rpsdid);

}