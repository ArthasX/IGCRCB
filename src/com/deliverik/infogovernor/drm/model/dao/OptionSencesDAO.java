/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;

/**
  * 概述: 备选场景DAO接口
  * 功能描述: 备选场景DAO接口
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
public interface OptionSencesDAO extends BaseHibernateDAO<OptionSencesInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OptionSencesInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OptionSencesInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final OptionSencesSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<OptionSencesInfo> findByCond(
			final OptionSencesSearchCond cond, final int start,
			final int count);

}