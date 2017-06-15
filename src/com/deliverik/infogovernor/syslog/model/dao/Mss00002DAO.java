/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCond;

/**
  * 概述: 告警规则表DAO接口
  * 功能描述: 告警规则表DAO接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00002DAO extends BaseHibernateDAO<Mss00002Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00002Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00002Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00002SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00002Info> findByCond(
			final Mss00002SearchCond cond, final int start,
			final int count) ;

}