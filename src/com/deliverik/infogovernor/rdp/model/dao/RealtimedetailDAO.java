/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;

/**
  * 概述: 日志信息DAO接口
  * 功能描述: 日志信息DAO接口
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
public interface RealtimedetailDAO extends BaseHibernateDAO<RealtimedetailInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RealtimedetailInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RealtimedetailInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RealtimedetailSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RealtimedetailInfo> findByCond(
			final RealtimedetailSearchCond cond, final int start,
			final int count);

}