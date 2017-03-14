/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;

/**
  * 概述: 缺省状态参与者关联流程类型定义表DAO接口
  * 功能描述: 缺省状态参与者关联流程类型定义表DAO接口
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public interface IG931DAO extends BaseHibernateDAO<IG931Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG931Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG931Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG931SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG931Info> findByCond(
			final IG931SearchCond cond, final int start,
			final int count);
	
	/**
     * psprpid主键值取得
     * 
     * @param 流程状态ID
     * @return psprpid主键值
     */
    public String getDpsprpidSequenceNextValue(String psdid);
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    public List<IG931Info> getIg931RelevantPdidfindByCond(final IG931SearchCond cond);
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果
     */
    public int getIg931RelevantPdidCount(final IG931SearchCond cond);
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> getIg380InfoByIg931Cond(final IG931SearchCond cond);
}