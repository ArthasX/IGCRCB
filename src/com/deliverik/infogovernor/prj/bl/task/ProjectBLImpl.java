/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectTBDAO;

public class ProjectBLImpl extends BaseBLImpl implements ProjectBL{
	
	protected ProjectTBDAO projectTBDAO;

	public void setProjectTBDAO(ProjectTBDAO projectTBDAO) {
		this.projectTBDAO = projectTBDAO;
	}

	public Project saveProject(Project project) throws BLException {
		return projectTBDAO.save(project);
	}

	public Project findByPK(Integer pid) throws BLException {
		return projectTBDAO.findByPK(pid);
	}

	public List<Project> findAllProject() throws BLException {
		return projectTBDAO.findAll();
	}

	public int getSearchCount(ProjectSearchCond cond) throws BLException {
		return projectTBDAO.getSearchCount(cond);
	}

	public List<Project> findByCond(ProjectSearchCond cond, int start, int count)
			throws BLException {
		return projectTBDAO.findByCond(cond, start, count);
	}
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectByPK(Integer pk)
		throws BLException {
		projectTBDAO.delete(checkExistInstance(pk));
	}
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Project checkExistInstance(Integer pk)
		throws BLException {
		Project instance = projectTBDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
