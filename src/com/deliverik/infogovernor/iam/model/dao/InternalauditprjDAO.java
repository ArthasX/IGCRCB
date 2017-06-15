/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;

/**
  * 概述: 内审项目DAO接口
  * 功能描述: 内审项目DAO接口
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
public interface InternalauditprjDAO extends BaseHibernateDAO<InternalauditprjInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InternalauditprjInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InternalauditprjInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InternalauditprjSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InternalauditprjInfo> findByCond(
			final InternalauditprjSearchCond cond, final int start,
			final int count);
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(final InternalauditprjSearchCond cond, final int start, final int count);
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond);

}