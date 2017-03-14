/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;

/**
  * 概述: mss00009DAO接口
  * 功能描述: mss00009DAO接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00009DAO extends BaseHibernateDAO<Mss00009Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00009Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00009Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Mss00009SearchCond cond) throws Exception;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00009Info> findByCond(
			final Mss00009SearchCond cond, final int start,
			final int count) throws Exception;

	
	/**
	 * 获取当前最大ID
	 * @return
	 */
	public int getMaxID();
}