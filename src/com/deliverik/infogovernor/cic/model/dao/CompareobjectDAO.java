/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;

/**
  * 概述: 对比对象DAO接口
  * 功能描述: 对比对象DAO接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareobjectDAO extends BaseHibernateDAO<CompareobjectInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareobjectInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareobjectInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareobjectSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareobjectInfo> findByCond(
			final CompareobjectSearchCond cond, final int start,
			final int count);
	/**
	 * 转移对比对象到 历史表中
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid);
	
	/**
	 * 根据规则删除对比对象
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid);
}