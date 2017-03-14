/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;

/**
  * 概述: 工作信息DAO接口
  * 功能描述: 工作信息DAO接口
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public interface WorkinfoDAO extends BaseHibernateDAO<WorkinfoInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkinfoInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkinfoInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkinfoSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkinfoInfo> findByCond(
			final WorkinfoSearchCond cond, final int start,
			final int count);

}