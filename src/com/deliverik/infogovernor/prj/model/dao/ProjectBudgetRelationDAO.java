/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;

/**
 * 概述: 项目于预算关系表查询DAO接口
 * 功能描述：项目于预算关系表查询DAO接口
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public interface ProjectBudgetRelationDAO extends BaseHibernateDAO<ProjectBudgetRelationInfo>{
	/***
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始页
	 * @param count 记录数量
	 * @return 检索到的结果集
	 */
	public List<ProjectBudgetRelationInfo> findBycond(ProjectBudgetRelationSearchCond cond,int start,int count);
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectBudgetRelationInfo findByPK(Serializable pk);
}
