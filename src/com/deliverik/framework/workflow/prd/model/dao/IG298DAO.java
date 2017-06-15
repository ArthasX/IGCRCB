/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;

/**
  * 概述: 流程状态可分派角色定义信息DAO接口
  * 功能描述: 流程状态可分派角色定义信息DAO接口
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public interface IG298DAO extends BaseHibernateDAO<IG298Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG298Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG298Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG298SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG298Info> findByCond(
			final IG298SearchCond cond, final int start,
			final int count);
	
	/**
	 * PSRDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSRDID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	public List<Role> searchToBeAssignRole(final String pdid, final String psdid);

}