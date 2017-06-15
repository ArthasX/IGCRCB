/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectBudgetRelationDAO;

/**
 * 概述:项目于算算关系表BL实现 
 * 功能描述：项目于算算关系表BL实现
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public class ProjectBudgetRelationBLImpl extends BaseBLImpl implements ProjectBudgetRelationBL{
	
	/** 项目于预算关系表DAO */
	private ProjectBudgetRelationDAO projectBudgetRelationDAO;

	/**
	 * 项目于预算关系表DAO设定
	 * @param projectBudgetRelationDAO 项目于预算关系表DAO
	 */
	public void setProjectBudgetRelationDAO(
			ProjectBudgetRelationDAO projectBudgetRelationDAO) {
		this.projectBudgetRelationDAO = projectBudgetRelationDAO;
	}
	
	/***
	 * 新增实体
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo saveProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException{
		ProjectBudgetRelationInfo projectBudgetRelationInfo = projectBudgetRelationDAO.save(projectBudgetRelation);
		return projectBudgetRelationInfo;
	}
	
	/***
	 * 删除实体
	 * @param projectBudgetRelation
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException{
		projectBudgetRelationDAO.delete(projectBudgetRelation);
	}
	
	/**
	 * 删除一组实体
	 * @param projectBudgetRelationList
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(List<ProjectBudgetRelationInfo> projectBudgetRelationList) throws BLException{
		projectBudgetRelationDAO.delete(projectBudgetRelationList);
	}
	
	/**
	 * 更新实体
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo updateProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException{
		checkExistInstance(projectBudgetRelation.getPbid());
		ProjectBudgetRelationInfo projectBudgetRelationInfo = projectBudgetRelationDAO.save(projectBudgetRelation);
		return projectBudgetRelationInfo;
	}
	
	/**
	 * 主键查询
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo findByPK(Integer pk) throws BLException{
		return projectBudgetRelationDAO.findByPK(pk);
	}
	
	/**
	 * 条件查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 * @throws BLException
	 */
	public List<ProjectBudgetRelationInfo> findByCond(ProjectBudgetRelationSearchCond cond,int start,int count) throws BLException{
		List<ProjectBudgetRelationInfo> findBycond = projectBudgetRelationDAO.findBycond(cond, start, count);
		return findBycond;
	}
	
	/**
	 * 检查实体是否存在
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo checkExistInstance(Integer pk)throws BLException{
		ProjectBudgetRelationInfo projectBudgetRelation = projectBudgetRelationDAO.findByPK(pk);
		if(projectBudgetRelation==null){
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return projectBudgetRelation;
	}
}
