/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;

/**
  * 概述: 表单策略表DAO接口
  * 功能描述: 表单策略表DAO接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG335DAO extends BaseHibernateDAO<IG335Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG335Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG335Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG335SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG335Info> findByCond(
			final IG335SearchCond cond, final int start,
			final int count);
	
	/**
	 * 超时通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 */
	public List<IG335Info> searchIG335Info(final String pdid, final  String psdid, final String pidid, final String psdconfirm);

}