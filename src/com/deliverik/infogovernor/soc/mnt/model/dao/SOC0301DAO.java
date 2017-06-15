/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;

/**
  * 概述: DMX实时监控性能表DAO接口
  * 功能描述: DMX实时监控性能表DAO接口
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public interface SOC0301DAO extends BaseHibernateDAO<SOC0301Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0301Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0301Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0301SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0301Info> findByCond(
			final SOC0301SearchCond cond, final int start,
			final int count);
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public  List<SOC0301Info> findByCondOrderByTimeAndName(final SOC0301SearchCond cond, final int start,
			final int count);

}