/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;

/**
 * <p>概述:流程类型定义DAO接口</p>
 * <p>功能描述：1.流程类型全部检索</p>
 * <p>          2.条件查询结果数</p>
 * <p>          3.主键查询</p>
 * <p>          4.条件查询结果</p>
 * <p>          5.条件检索处理（人员角色检索SearchCond 全部检索）</p>
 * <p>          6.条件检索处理（人员角色检索SearchCond）</p>
 * <p>          7.检索处理（运维计划用）</p>
 * <p>创建记录：</p>
 * <p>修改记录：杨盛楠	2010-12-13</p>
 */
public interface IG380DAO extends BaseHibernateDAO<IG380Info> {

	/**
	 * 功能：流程类型全部检索
	 * @return 流程类型定义结果集
	 */
	public List<IG380Info> findAll();
	
	/**
	 * 功能：条件查询结果数
	 * @param cond
	 * @return 查询结果数量
	 */
	public int getSearchCount(final IG380SearchCond cond);

	/**
	 * 查询最新版本记录个数
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public int getSearchLastCount(final IG380SearchCond cond);
	
	/**
	 * 查询历史版本记录个数
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public int getSearchHistoryCount(final IG380SearchCond cond);

	/**
	 * 功能：主键查询
	 * @param prid
	 * @return IG380Info
	 */
	public IG380Info findByPK(Serializable prid);

	public List<IG380Info> findByCond(final IG380SearchCond cond, final int start, final int count);
	
	
	public List<IG380Info> findLastByCond(final IG380SearchCond cond, final int start, final int count);
	
	
	public List<IG380Info> findHistoryByCond(final IG380SearchCond cond, final int start, final int count);
	
	/**
	 * 指定用户可发起自定义流程查询处理
	 * @param userid 用户ID
	 * @param pdstatus 自定义流程状态
	 * @return 指定用户可发起自定义流程列表
	 */
	public List<IG380Info> findSelfDefinitionByUserId(final String userid, final String pdstatus);
	
	/**
	 * 功能：条件检索处理（人员角色检索SearchCond）
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(final UserRoleSearchCond cond, final Integer ptid
			, final String pdstatus);
	
	/**
	 * PDID主键值取得
	 * @param pdid_one 模板标识
	 * 
	 * @return PDID主键值
	 */
	public String getPdidSequenceNextValue(String firstsite,String pdsequence);
	
	/**
	 * 流程定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public String upgradeProcessDefVersion(String pdid);

	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence);
	
	/**
	 * 功能：检索处理（运维计划用）
	 * @return 检索结果列表
	 */
	public List<IG380Info> findSelfDefinitionAll();

	/**
     * 查询相关发起的自定义流程类型信息
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    public List<IG913Info> relevantProcessfindByCond(final IG913SearchCond cond);
    
    /**
     * 查询缺省权限的相关发起的自定义流程类型信息
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    public List<IG913Info> relevantProcessfindByCondDefault(final IG913SearchCond cond);
}
