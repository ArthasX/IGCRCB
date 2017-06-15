/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prj.bl.IGPRJ02BL;
import com.deliverik.infogovernor.prj.dto.ProjectPlanDTO;
import com.deliverik.infogovernor.prj.vo.MilestoneInfoVO;

public class IGPRJ0103Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRJ0103Action.class);
	
	/**
	 * <p>
	 * Title : InfoGovernor 信息服务管理平台
	 * </p>
	 * <p>
	 * Description: 服务管理_项目管理_登记milestoneACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGPRJ02BL igprj02BL = (IGPRJ02BL) getBean("igprj02BL");
		Integer projectId = Integer.valueOf(req.getParameter("projectId"));
		ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
		projectPlanDTO.setProjectId(projectId);
		projectPlanDTO = igprj02BL.getCurrentMS(projectPlanDTO);
		MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
		milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
		milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
		req.setAttribute("milestoneInfoVO", milestoneInfoVO);
		return mapping.findForward("DISP");
	}

}
