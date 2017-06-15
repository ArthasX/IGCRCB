/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;

public interface ProjectBL extends BaseBL{
	
	public Project saveProject(Project project) throws BLException;
	
	public Project findByPK(Integer pid) throws BLException;
	
	public List<Project> findAllProject() throws BLException;
	
	public int getSearchCount(ProjectSearchCond cond) throws BLException;
	
	public List<Project> findByCond(ProjectSearchCond cond, int start, int count) throws BLException;
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteProjectByPK(Integer pk) throws BLException ;
	
}
