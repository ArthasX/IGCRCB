/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;

/**
  * 概述: SOC0151VWDAO接口
  * 功能描述: SOC0151VWDAO接口
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
public interface SOC0151VWDAO extends BaseHibernateDAO<SOC0151VWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0151VWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0151VWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0151VWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> findByCond(
			final SOC0151VWSearchCond cond, final int start,
			final int count);
	/**
	 * 获取取值范围下拉数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151VWSearchCond cond);
}