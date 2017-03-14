/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.bl.IGPRJ02BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.dto.ProjectPlanDTO;
import com.deliverik.infogovernor.prj.form.ConfirmMSForm;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.form.IGPRJ0101Form;
import com.deliverik.infogovernor.prj.form.ProjectPlanForm;
import com.deliverik.infogovernor.prj.vo.IGPRJ0101VO;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;
import com.deliverik.infogovernor.prj.vo.MilestoneInfoVO;

public class IGFIN0106Action extends BaseAction {
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//BL取得
		IGPRJ01BL prjBL = (IGPRJ01BL) getBean("igprj01BL");
		IGPRJ02BL igprj02BL = (IGPRJ02BL) getBean("igprj02BL");
		
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter()) ){
			IGPRJ0101Form igprj0101Form = (IGPRJ0101Form) actionForm;
			
			getPaginDTO(req,"IGKGM0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				igprj0101Form = (IGPRJ0101Form) req.getSession().getAttribute("IGPRJ0101Form");
				if ( igprj0101Form == null ) {
					igprj0101Form = new IGPRJ0101Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(igprj0101Form.getFromCount());
					} else {
						igprj0101Form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					igprj0101Form = (IGPRJ0101Form) req.getSession().getAttribute("IGPRJ0101Form");
					if (igprj0101Form !=null) {
						igprj0101Form.setFromCount(0);
					}
				}
			}
			
			
			//pDto.setFromCount(igprj0101Form.getFromCount());
			int maxCnt = getMaxDataCount("IGKGM0101");
			
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProjectSearchCond(igprj0101Form);
			
			igprj01dto.setMaxSearchCount(maxCnt);
			
			igprj01dto.setPagingDto(pDto);
			
			igprj01dto = prjBL.findProjectByCond(igprj01dto);
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setProjectList(igprj01dto.getProjectList());
			req.setAttribute("igprj0101VO", igprj0101VO);
			
		} else if ("DETAIL".equals(mapping.getParameter())){
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			String projectId = req.getParameter("id");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			igprj01dto.setProjectId(projectId);
			igprj01dto.setUser(user);
			igprj01dto = prjBL.findProjectById(igprj01dto);
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setActionnameList(igprj01dto.getActionnameList());
			igprj0101VO.setProject(igprj01dto.getProject());

			String type = req.getParameter("type");
			req.setAttribute("igprj0101VO", igprj0101VO);
			if(type != null && "assess".equals(type)){ //项目点评
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("ASSESS");
			} else if (type != null && "close".equals(type)){ //项目关闭
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("CLOSE");
			} else if (type != null && "projectPlan".equals(type)){ //项目计划
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("PROJECTPLAN");
			} else if (type != null && "adjustProjectPlan".equals(type)){ //调整计划
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				projectPlanDTO = igprj02BL.getCurrentMS(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				return mapping.findForward("ADJUSTPROJECTPLAN");	
			}else if (type != null && "confirmMilestone".equals(type)){ //项目进展
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				projectPlanDTO = igprj02BL.getCurrentMS(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				return mapping.findForward("CONFIRMMILESTONE");
			}else if (type != null && "viewProjectPlan".equals(type)){ //项目监控
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				projectPlanDTO = igprj02BL.getCurrentForViewMS(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				return mapping.findForward("VIEW_PROJECTPLAN");
			}
		} else if ("INSERT_ASSESS".equals(mapping.getParameter())){ //项目点评
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm)actionForm;
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProjectLog(detailForm);
			igprj01dto.setIGPRJ0101DetailForm(detailForm);
			prjBL.insertProjectLog(igprj01dto);
			String projectId = req.getParameter("pid");
			return new ActionForward("/IGPRJ0101_Detail.do?id=" + projectId);   
		} else if ("INSERT_CLOSE".equals(mapping.getParameter())){
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm)actionForm;
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProject(detailForm);
			igprj01dto.setProjectLog(detailForm);
			igprj01dto.setIGPRJ0101DetailForm(detailForm);
			prjBL.closeProject(igprj01dto);
			String projectId = req.getParameter("pid");
			return new ActionForward("/IGPRJ0101_Detail.do?id=" + projectId);   
		} else if ("HISTORY".equals(mapping.getParameter())){
			IGPRJ01DTO prjdto = new IGPRJ01DTO();
			prjdto = prjBL.findAllProject(prjdto);
			IGPRJ01HistoryVO[] historyVOs = prjdto.getHistoryVOs();
			req.setAttribute("historyVOs", historyVOs);
		} else if ("PROJECTPLAN".equals(mapping.getParameter())){
			ProjectPlanForm projectPlanForm = (ProjectPlanForm)actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
			projectPlanDTO.setProjectPlan(projectPlanForm);
			projectPlanDTO.setProjectLog(projectPlanForm);
			igprj02BL.insertEntityAction(projectPlanDTO);
			String projectId = req.getParameter("pid");
			return new ActionForward("/IGPRJ0101_Detail.do?id=" + projectId);  
		} else if ("ADJUST_PROJECTPLAN".equals(mapping.getParameter())){
			String projectId = req.getParameter("pid");
			ProjectPlanForm projectPlanForm = (ProjectPlanForm)actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
			projectPlanDTO.setProjectPlan(projectPlanForm);
			projectPlanDTO.setProjectId(Integer.valueOf(projectId));
			igprj02BL.adjustMS(projectPlanDTO);
			return new ActionForward("/IGPRJ0101_Detail.do?id=" + projectId);  
		}else if ("CONFIRM_PROJECTPLAN".equals(mapping.getParameter())){
			String projectId = req.getParameter("pid");
			ConfirmMSForm confirmMSForm = (ConfirmMSForm)actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO(); 
			


			projectPlanDTO.setProjectPlan(confirmMSForm);
			projectPlanDTO.setProjectId(Integer.valueOf(projectId));
			igprj02BL.confirmMS(projectPlanDTO);
			return new ActionForward("/IGPRJ0101_Detail.do?id=" + projectId);  
		}
		
		return mapping.findForward("DISP");
	}
	

}
