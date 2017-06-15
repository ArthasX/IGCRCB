/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectPlanTBDAO;

public class ProjectPlanBLImpl extends BaseBLImpl implements ProjectPlanBL{
	
	protected ProjectPlanTBDAO projectPlanTBDAO;
	
	public void setProjectPlanTBDAO(ProjectPlanTBDAO projectPlanTBDAO) {
		this.projectPlanTBDAO = projectPlanTBDAO;
	}

	public ProjectPlan findByPK(Integer pid) throws BLException {
		return projectPlanTBDAO.findByPK(pid);
	}
	
	public List<ProjectPlan> findByCond(ProjectPlanSearchCond cond, int start,
			int count) throws BLException {
		return projectPlanTBDAO.findByCond(cond, start, count);
	}

	public ProjectPlan saveProjectPlan(ProjectPlan projectPlan) throws BLException {
		return projectPlanTBDAO.save(projectPlan);
	}
	
	public void updateProjectPlan(ProjectPlan projectPlan) throws BLException{
		checkExistInstance(projectPlan.getPplid());
		projectPlanTBDAO.save(projectPlan);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectPlanByPK(Integer pk) throws BLException {
		projectPlanTBDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ProjectPlan checkExistInstance(Integer pk)
		throws BLException {
		ProjectPlan instance = projectPlanTBDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
