/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;

/**
  * 概述: 状态级私有表单值记录表DAO接口
  * 功能描述: 状态级私有表单值记录表DAO接口
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public interface IG561DAO extends BaseHibernateDAO<IG561Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG561Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG561Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG561SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG561Info> findByCond(
			final IG561SearchCond cond, final int start,
			final int count);
	
	
	/**
     * 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @Title: searchIG561VW
     * @Description: 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @param 
     * prid 流程id 
     * ppuserid 参与者id
     * isAdmin 是否是流程管理员
     * @return list561VW
     * @throws
     */
    public List<IG561VWInfo> searchIG561VW(final String prid ,final String ppuserid,final boolean isAdmin);


}