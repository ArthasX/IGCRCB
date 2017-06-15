/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;

/**
  * 概述: 提醒信息表DAO接口
  * 功能描述: 提醒信息表DAO接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface RemindInfoDAO extends BaseHibernateDAO<RemindInfoInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RemindInfoInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RemindInfoInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RemindInfoSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RemindInfoInfo> findByCond(
			final RemindInfoSearchCond cond, final int start,
			final int count);

}