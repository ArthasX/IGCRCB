/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;

/**
  * 概述: 端到端关系表DAO接口
  * 功能描述: 端到端关系表DAO接口
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
public interface PortRelationDAO extends BaseHibernateDAO<PortRelationInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PortRelationInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PortRelationInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PortRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PortRelationInfo> findByCond(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * 剩余Hyper查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<String> findByCondStr(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * 业务系统查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondBuss(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * 主机&HBA关键字查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondHost(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * 交换机关键字查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondSwitch(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * FA
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondFa(
			final PortRelationSearchCond cond, final int start,
			final int count);

	/**
	 * 查询meta与geteKeeper
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondHyper(
			final PortRelationSearchCond cond, final int start,
			final int count);	
	/**
	 * 线路查询Hyper得到FAeiid
	 * @return
	 */		
	public List<String> getHypeEiid(final String eiid,final String einame);
}