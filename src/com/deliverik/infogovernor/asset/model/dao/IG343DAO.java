/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;

/**
  * 概述: IG343DAO接口
  * 功能描述: IG343DAO接口
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public interface IG343DAO extends BaseHibernateDAO<IG343Info> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG343Info> findByCond(
			final IG343SearchCond cond, final int start, final int count);
}