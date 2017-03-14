/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;

/**
  * 概述: 风险管理提示接收者数据表DAO接口
  * 功能描述: 风险管理提示接收者数据表DAO接口
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public interface AcceptuserDAO extends BaseHibernateDAO<AcceptuserInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AcceptuserInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AcceptuserInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AcceptuserSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AcceptuserInfo> findByCond(
			final AcceptuserSearchCond cond, final int start,
			final int count);

}