/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;

/**
  * 概述: IG342DAO接口
  * 功能描述: IG342DAO接口
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public interface IG342DAO extends BaseHibernateDAO<IG342Info> {

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG342SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG342Info> findByCond(
			final IG342SearchCond cond, final int start,
			final int count);

}