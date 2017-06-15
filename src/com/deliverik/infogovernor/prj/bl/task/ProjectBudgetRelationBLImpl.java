/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectBudgetRelationDAO;

/**
 * ����:��Ŀ�������ϵ��BLʵ�� 
 * ������������Ŀ�������ϵ��BLʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public class ProjectBudgetRelationBLImpl extends BaseBLImpl implements ProjectBudgetRelationBL{
	
	/** ��Ŀ��Ԥ���ϵ��DAO */
	private ProjectBudgetRelationDAO projectBudgetRelationDAO;

	/**
	 * ��Ŀ��Ԥ���ϵ��DAO�趨
	 * @param projectBudgetRelationDAO ��Ŀ��Ԥ���ϵ��DAO
	 */
	public void setProjectBudgetRelationDAO(
			ProjectBudgetRelationDAO projectBudgetRelationDAO) {
		this.projectBudgetRelationDAO = projectBudgetRelationDAO;
	}
	
	/***
	 * ����ʵ��
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo saveProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException{
		ProjectBudgetRelationInfo projectBudgetRelationInfo = projectBudgetRelationDAO.save(projectBudgetRelation);
		return projectBudgetRelationInfo;
	}
	
	/***
	 * ɾ��ʵ��
	 * @param projectBudgetRelation
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException{
		projectBudgetRelationDAO.delete(projectBudgetRelation);
	}
	
	/**
	 * ɾ��һ��ʵ��
	 * @param projectBudgetRelationList
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(List<ProjectBudgetRelationInfo> projectBudgetRelationList) throws BLException{
		projectBudgetRelationDAO.delete(projectBudgetRelationList);
	}
	
	/**
	 * ����ʵ��
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
	 * ������ѯ
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo findByPK(Integer pk) throws BLException{
		return projectBudgetRelationDAO.findByPK(pk);
	}
	
	/**
	 * ������ѯ
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
	 * ���ʵ���Ƿ����
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo checkExistInstance(Integer pk)throws BLException{
		ProjectBudgetRelationInfo projectBudgetRelation = projectBudgetRelationDAO.findByPK(pk);
		if(projectBudgetRelation==null){
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return projectBudgetRelation;
	}
}
