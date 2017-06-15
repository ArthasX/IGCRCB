/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectBudgetRelationTB;

/**
 * 概述: 项目于预算关系表查询DAO实现
 * 功能描述：项目于预算关系表查询DAO实现
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public class ProjectBudgetRelationDAOImpl extends BaseHibernateDAOImpl<ProjectBudgetRelationInfo> implements ProjectBudgetRelationDAO{
	/**
	 * 构造方法
	 */
	public ProjectBudgetRelationDAOImpl(){
		super(ProjectBudgetRelationTB.class);
	}
	
	
	/***
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始页
	 * @param count 记录数量
	 * @return 检索到的结果集
	 */
	public List<ProjectBudgetRelationInfo> findBycond(ProjectBudgetRelationSearchCond cond,int start,int count) {
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c,start,count);
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectBudgetRelationInfo findByPK(Serializable pk) {
		ProjectBudgetRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(ProjectBudgetRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getBid_eq()!=null&&cond.getBid_eq()>0){
			c.add(Expression.eq("bid", cond.getBid_eq()));
		}
		if(cond.getPid_eq()!=null&&cond.getPid_eq()>0){
			c.add(Expression.eq("pid", cond.getPid_eq()));
		}
		return c;
	}
}
