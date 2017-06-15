/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;

/**
 * 概述: 项目于算算关系表BL接口
 * 功能描述：项目于算算关系表BL接口
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public interface ProjectBudgetRelationBL extends BaseBL{
	/***
	 * 新增实体
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo saveProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/***
	 * 删除实体
	 * @param projectBudgetRelation
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/**
	 * 删除一组实体
	 * @param projectBudgetRelationList
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(List<ProjectBudgetRelationInfo> projectBudgetRelationList) throws BLException;
	
	/**
	 * 更新实体
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo updateProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/**
	 * 主键查询
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo findByPK(Integer pk) throws BLException;
	
	/**
	 * 条件查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 * @throws BLException
	 */
	public List<ProjectBudgetRelationInfo> findByCond(ProjectBudgetRelationSearchCond cond,int start,int count) throws BLException;
}
