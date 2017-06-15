/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectLogTBDAO;

public class ProjectLogBLImpl extends BaseBLImpl implements ProjectLogBL{
	
	protected ProjectLogTBDAO projectLogTBDAO;
	
	public void setProjectLogTBDAO(ProjectLogTBDAO projectLogTBDAO) {
		this.projectLogTBDAO = projectLogTBDAO;
	}

	public ProjectLog saveProjectLog(ProjectLog projectLog) throws BLException {
		return projectLogTBDAO.save(projectLog);
	}

	public List<ProjectLog> findByCond(ProjectLogSearchCond cond, int start,
			int count) throws BLException {
		return projectLogTBDAO.findByCond(cond, start, count);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteProjectLogByPK(Integer pk) throws BLException {
		projectLogTBDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ProjectLog checkExistInstance(Integer pk)
		throws BLException {
		ProjectLog instance = projectLogTBDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
