/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;

/**
  * 概述: 状态可分派机构定义表DAO接口
  * 功能描述: 状态可分派机构定义表DAO接口
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public interface IG299DAO extends BaseHibernateDAO<IG299Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG299Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG299Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG299SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG299Info> findByCond(
			final IG299SearchCond cond, final int start,
			final int count);

	/**
	 * PSODID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSODID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的角色列表
	 */
	public List<Organization> searchToBeAssignOrg(final String pdid, final int levellen, final String psdid);
}