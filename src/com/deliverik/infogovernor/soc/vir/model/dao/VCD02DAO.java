/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;

/**
  * 概述: 虚拟资源项目信息DAO接口
  * 功能描述: 虚拟资源项目信息DAO接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD02DAO extends BaseHibernateDAO<VCD02Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD02Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD02Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final VCD02SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD02Info> findByCond(
			final VCD02SearchCond cond, final int start,
			final int count);

}