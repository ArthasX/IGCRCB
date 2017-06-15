/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;

/**
  * 概述: 集成告警表DAO接口
  * 功能描述: 集成告警表DAO接口
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public interface IgalarmDAO extends BaseHibernateDAO<IgalarmInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgalarmInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgalarmInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IgalarmSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> findByCond(
			final IgalarmSearchCond cond, final int start,
			final int count);
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IGCRC0208VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);

	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
	

	/**
	 * 条件检索处理(没有默认排序)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> findByCondNoSort(final IgalarmSearchCond cond, final int start, final int count);
}