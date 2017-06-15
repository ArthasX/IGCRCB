/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;

/**
  * 概述: MSGFILTERDAO接口
  * 功能描述: MSGFILTERDAO接口
  * 创建记录: 2013/08/21
  * 修改记录: 
  */
public interface MSGFILTERDAO extends BaseHibernateDAO<MSGFILTERInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MSGFILTERInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MSGFILTERInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MSGFILTERSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MSGFILTERInfo> findByCond(
			final MSGFILTERSearchCond cond, final int start,
			final int count);

}