/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;

/**
 * ����: ��Ŀ�������ϵ��BL�ӿ�
 * ������������Ŀ�������ϵ��BL�ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public interface ProjectBudgetRelationBL extends BaseBL{
	/***
	 * ����ʵ��
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo saveProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/***
	 * ɾ��ʵ��
	 * @param projectBudgetRelation
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/**
	 * ɾ��һ��ʵ��
	 * @param projectBudgetRelationList
	 * @throws BLException
	 */
	public void deleteProjectBudgetRelation(List<ProjectBudgetRelationInfo> projectBudgetRelationList) throws BLException;
	
	/**
	 * ����ʵ��
	 * @param projectBudgetRelation
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo updateProjectBudgetRelation(ProjectBudgetRelationInfo projectBudgetRelation) throws BLException;
	
	/**
	 * ������ѯ
	 * @param pk
	 * @return
	 * @throws BLException
	 */
	public ProjectBudgetRelationInfo findByPK(Integer pk) throws BLException;
	
	/**
	 * ������ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 * @throws BLException
	 */
	public List<ProjectBudgetRelationInfo> findByCond(ProjectBudgetRelationSearchCond cond,int start,int count) throws BLException;
}
