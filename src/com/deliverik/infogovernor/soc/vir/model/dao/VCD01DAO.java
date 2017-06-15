/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCond;

/**
  * 概述: vCloud ServiceInstanceDAO接口
  * 功能描述: vCloud ServiceInstanceDAO接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD01DAO extends BaseHibernateDAO<VCD01Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD01Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD01Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VCD01SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD01Info> findByCond(
			final VCD01SearchCond cond, final int start,
			final int count);

}