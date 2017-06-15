/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;

/**
  * 概述: 自定义流程配置表DAO接口
  * 功能描述: 自定义流程配置表DAO接口
  * 创建记录: 2012/11/05
  * 修改记录: 
  */
public interface CustomConfigurationDAO extends BaseHibernateDAO<CustomConfigurationInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CustomConfigurationInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CustomConfigurationInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CustomConfigurationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CustomConfigurationInfo> findByCond(
			final CustomConfigurationSearchCond cond, final int start,
			final int count);

}