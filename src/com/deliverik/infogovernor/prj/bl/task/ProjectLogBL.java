/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;

public interface ProjectLogBL extends BaseBL{
	
	public ProjectLog saveProjectLog(ProjectLog projectLog) throws BLException;
	
	public List<ProjectLog> findByCond(ProjectLogSearchCond cond,int start, int count) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectLogByPK(Integer pk) throws BLException;
	
}
