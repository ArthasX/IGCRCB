/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;

/**
  * 概述: 资源申请虚机信息DAO接口
  * 功能描述: 资源申请虚机信息DAO接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD03DAO extends BaseHibernateDAO<VCD03Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD03Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD03Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VCD03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD03Info> findByCond(
			final VCD03SearchCond cond, final int start,
			final int count);

}