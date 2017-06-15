/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCond;

public interface ProjectPlanBL extends BaseBL{
	
	public ProjectPlan saveProjectPlan(ProjectPlan projectPlan) throws BLException;
	
	public List<ProjectPlan> findByCond(ProjectPlanSearchCond cond,int start, int count) throws BLException;
	
	public ProjectPlan findByPK(Integer pid) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectPlanByPK(Integer pk) throws BLException;
	
	public void updateProjectPlan(ProjectPlan projectPlan) throws BLException;
}
