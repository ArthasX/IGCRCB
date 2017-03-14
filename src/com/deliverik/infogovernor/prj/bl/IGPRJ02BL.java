/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prj.dto.ProjectPlanDTO;

public interface IGPRJ02BL {
	
	public ProjectPlanDTO insertEntityAction(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO getCurrentMS(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO adjustMS(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO adjustMSv(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO updateProjectPlan(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO confirmMS(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO getCurrentForViewMS(ProjectPlanDTO dto) throws BLException;

	public ProjectPlanDTO getCurrentMSv(ProjectPlanDTO dto) throws BLException ;
	
	public ProjectPlanDTO getCurrentMSj(ProjectPlanDTO dto) throws BLException;
	
	public ProjectPlanDTO setColor(ProjectPlanDTO dto) throws BLException ;
	
}
