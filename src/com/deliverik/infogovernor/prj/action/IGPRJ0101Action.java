/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.vo.IGFIN01012VO;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.bl.IGPRJ02BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.dto.ProjectPlanDTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.form.IGPRJ0101Form;
import com.deliverik.infogovernor.prj.form.ProjectPlanForm;
import com.deliverik.infogovernor.prj.vo.IGPRJ0101VO;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;
import com.deliverik.infogovernor.prj.vo.MilestoneInfoVO;

public class IGPRJ0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRJ0101Action.class);
	
	/**
	 * <p>
	 * Title : InfoGovernor ��Ϣ�������ƽ̨
	 * </p>
	 * <p>
	 * Description: �������_��Ŀ����_��ѯACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		// BLȡ��
		IGPRJ01BL prjBL = (IGPRJ01BL) getBean("igprj01BL");
		IGPRJ02BL igprj02BL = (IGPRJ02BL) getBean("igprj02BL");
		
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter()) ) {
			IGPRJ0101Form igprj0101Form = (IGPRJ0101Form) actionForm;

			String path = req.getParameter("path");
			if("homepage".equals(path)){
				igprj0101Form.setPstatus("O");
			}
			getPaginDTO(req,"IGPRJ0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
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
			
			int maxCnt = getMaxDataCount("IGPRJ0101");
			
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProjectSearchCond(igprj0101Form);
			igprj01dto.setMaxSearchCount(maxCnt);
			
			igprj01dto.setPagingDto(pDto);
			
			igprj01dto = prjBL.findProjectByCond(igprj01dto);
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setVoList(igprj01dto.getVoList());
//			igprj0101VO.setProjectList(igprj01dto.getProjectList());
			req.setAttribute("igprj0101VO", igprj0101VO);
			super.<IGPRJ0101VO>setVO(req, igprj0101VO);
			List<ActionMessage> messageList = igprj01dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			return mapping.findForward("DISP");
		} else if ("DETAIL".equals(mapping.getParameter())) {
			String projectId = req.getParameter("pid");
			String type = req.getParameter("type");
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm) actionForm;
			//ʱ��Ĭ��Ϊ��ǰʱ��
			detailForm.setPltime(IGStringUtils.getCurrentDateTime());
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProjectId(projectId);
 			igprj01dto.setUser(user);
			igprj01dto = prjBL.findProjectById(igprj01dto);
			
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setActionnameList(igprj01dto.getActionnameList());
			igprj0101VO.setProject(igprj01dto.getProject());
			igprj0101VO.setForm(igprj01dto.getIgPrj0102Form());

			req.setAttribute("igprj0101VO", igprj0101VO);
			if (type != null && "assess".equals(type)) { // ��Ŀ��־
				String projectType = req.getParameter("pltype");
				if(StringUtils.isNotEmpty(projectType)){
					igprj01dto.setProjectType(projectType);
				}
				igprj01dto.setIGPRJ0101DetailForm(detailForm);
				//ȡ����־���
				igprj01dto = prjBL.findProjectLogType(igprj01dto);
				igprj0101VO.setCodeDetailList(igprj01dto.getCodeDetailList());
				igprj0101VO.setProjectLogContractSum(igprj01dto.getProjectLogContractSum());
				igprj0101VO.setProjectLogBusinessFirst(igprj01dto.getProjectLogBusinessFirst());
				igprj0101VO.setProjectLogBusinessSecond(igprj01dto.getProjectLogBusinessSecond());
				igprj0101VO.setProjectLogBusinessThird(igprj01dto.getProjectLogBusinessThird());
				igprj0101VO.setProjectLogBusinessFourth(igprj01dto.getProjectLogBusinessFourth());
				igprj0101VO.setProjectLogBusinessFifth(igprj01dto.getProjectLogBusinessFifth());
				igprj0101VO.setProjectLogBusinessSum(igprj01dto.getProjectLogBusinessSum());
				igprj0101VO.setProjectLogBusinessNotsum(igprj01dto.getProjectLogBusinessNotsum());
				igprj0101VO.setProjectLogBusinessScale(igprj01dto.getProjectLogBusinessScale());
				igprj0101VO.setProjectLogBusinessNotscale(igprj01dto.getProjectLogBusinessNotscale());
				igprj0101VO.setProjectLogContractSumTerm(igprj01dto.getProjectLogContractSumTerm());
				igprj0101VO.setProjectLogContractFirst(igprj01dto.getProjectLogContractFirst());
				igprj0101VO.setProjectLogContractFirstTerm(igprj01dto.getProjectLogContractFirstTerm());
				igprj0101VO.setProjectLogContractSecond(igprj01dto.getProjectLogContractSecond());
				igprj0101VO.setProjectLogContractSecondTerm(igprj01dto.getProjectLogContractSecondTerm());
				igprj0101VO.setProjectLogContractThird(igprj01dto.getProjectLogContractThird());
				igprj0101VO.setProjectLogContractThirdTerm(igprj01dto.getProjectLogContractThirdTerm());
				igprj0101VO.setProjectLogContractFourth(igprj01dto.getProjectLogContractFourth());
				igprj0101VO.setProjectLogContractFourthTerm(igprj01dto.getProjectLogContractFourthTerm());
				igprj0101VO.setProjectLogContractFifth(igprj01dto.getProjectLogContractFifth());
				igprj0101VO.setProjectLogContractFifthTerm(igprj01dto.getProjectLogContractFifthTerm());
				igprj0101VO.setPbsummaryList(igprj01dto.getPbsummaryList());
				igprj0101VO.setPlcnumber(igprj01dto.getPlcnumber());
				if(StringUtils.isNotEmpty(igprj01dto.getProjectLogInfo())){
					igprj0101VO.setProjectLogInfo(igprj01dto.getProjectLogInfo());
				}
				detailForm = igprj01dto.getIGPRJ0101DetailForm();
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("ASSESS");
			} else if (type != null && "close".equals(type)) { // ��Ŀ�ر�
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("CLOSE");
			} else if (type != null && "projectPlan".equals(type)) { // ��Ŀ�ƻ�
				req.setAttribute("igprj0101VO", igprj0101VO);
				return mapping.findForward("PROJECTPLAN");
			} else if (type != null && "adjustProjectPlan".equals(type)) { // �����ƻ�
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				String pstatus = req.getParameter("pplstatusDisp");
				if(StringUtils.isEmpty(pstatus)){
					pstatus= "";
				}
				projectPlanDTO.setPplstatus(pstatus);
				projectPlanDTO = igprj02BL.getCurrentMSv(projectPlanDTO);
				projectPlanDTO = igprj02BL.setColor(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				milestoneInfoVO.setPstatus(projectPlanDTO.getPstatus());
				milestoneInfoVO.setPtime(projectPlanDTO.getPtime());
				milestoneInfoVO.setAttachmentList(projectPlanDTO.getAttachmentList());
				milestoneInfoVO.setSygTime(projectPlanDTO.getSygTime());
				milestoneInfoVO.setColorA(projectPlanDTO.getColorA());
				milestoneInfoVO.setColorB(projectPlanDTO.getColorB());
				milestoneInfoVO.setColorC(projectPlanDTO.getColorC());
				milestoneInfoVO.setColorD(projectPlanDTO.getColorD());
				milestoneInfoVO.setColorE(projectPlanDTO.getColorE());
				milestoneInfoVO.setColorF(projectPlanDTO.getColorF());
				milestoneInfoVO.setColorG(projectPlanDTO.getColorG());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				req.setAttribute("popentime", req.getParameter("popentime"));
				req.setAttribute("pclosetime", req.getParameter("pclosetime"));
				if(StringUtils.isNotEmpty(req.getParameter("pplstatusDisp"))){
					req.setAttribute("pplstatusDisp", req.getParameter("pplstatusDisp"));
				}
				return mapping.findForward("ADJUSTPROJECTPLAN");
			} else if (type != null && "confirmMilestone".equals(type)) { // ��Ŀ��չ
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				String pstatus = req.getParameter("pplstatusDisp");
				if(StringUtils.isEmpty(pstatus)){
					pstatus= "";
				}
				projectPlanDTO.setPplstatus(pstatus);
				projectPlanDTO = igprj02BL.getCurrentMSj(projectPlanDTO);
				projectPlanDTO = igprj02BL.setColor(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				milestoneInfoVO.setPstatus(projectPlanDTO.getPstatus());
				milestoneInfoVO.setAttachmentList(projectPlanDTO.getAttachmentList());
				milestoneInfoVO.setColorA(projectPlanDTO.getColorA());
				milestoneInfoVO.setColorB(projectPlanDTO.getColorB());
				milestoneInfoVO.setColorC(projectPlanDTO.getColorC());
				milestoneInfoVO.setColorD(projectPlanDTO.getColorD());
				milestoneInfoVO.setColorE(projectPlanDTO.getColorE());
				milestoneInfoVO.setColorF(projectPlanDTO.getColorF());
				milestoneInfoVO.setColorG(projectPlanDTO.getColorG());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				if(StringUtils.isNotEmpty(req.getParameter("pplstatusDisp"))){
					req.setAttribute("pplstatusDisp", req.getParameter("pplstatusDisp"));
				}
				return mapping.findForward("CONFIRMMILESTONE");
			} else if (type != null && "viewProjectPlan".equals(type)) { // ��Ŀ���
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				projectPlanDTO = igprj02BL.getCurrentForViewMS(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				milestoneInfoVO.setProjectLogMap(projectPlanDTO.getProjectLogMap());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
				return mapping.findForward("VIEW_PROJECTPLAN");
			}else if(type==null){
				req.setAttribute("igprj0101VO", igprj0101VO);
				ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
				projectPlanDTO.setProjectId(Integer.valueOf(projectId));
				projectPlanDTO = igprj02BL.getCurrentForViewMS(projectPlanDTO);
				MilestoneInfoVO milestoneInfoVO = new MilestoneInfoVO();
				milestoneInfoVO.setMilestoneInfoList(projectPlanDTO.getMilestoneInfoList());
				milestoneInfoVO.setProjectPlan(projectPlanDTO.getProjectPlan());
				milestoneInfoVO.setProjectLogMap(projectPlanDTO.getProjectLogMap());
				req.setAttribute("milestoneInfoVO", milestoneInfoVO);
			}
		} else if ("INSERT_ASSESS".equals(mapping.getParameter())) { // ��Ŀ����
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm) actionForm;
			detailForm.setUserId(user.getUserid());
			detailForm.setPlusername(user.getUsername());
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProjectLog(detailForm);
			igprj01dto.setIGPRJ0101DetailForm(detailForm);
			prjBL.insertProjectLog(igprj01dto);
			String projectId = req.getParameter("pid");
			req.setAttribute("msg", "��Ŀ��־�ύ����ɹ���");
			return new ActionForward("/IGPRJ0101_Detail.do?pid=" + projectId);
		} else if ("INSERT_CLOSE".equals(mapping.getParameter())) {  //�ر���Ŀ
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm) actionForm;
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			detailForm.setUserId(user.getUserid());
			detailForm.setPlusername(user.getUsername());
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			igprj01dto.setProject(detailForm);
			igprj01dto.setProjectLog(detailForm);
			igprj01dto.setIGPRJ0101DetailForm(detailForm);
			prjBL.closeProject(igprj01dto);
			String projectId = req.getParameter("pid");
			req.setAttribute("msg", "��Ŀ�رմ���ɹ���");
			return new ActionForward("/IGPRJ0101_Detail.do?pid=" + projectId);
		} else if ("HISTORY".equals(mapping.getParameter())) {//�鿴��ʷ
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			String projectId = req.getParameter("pid");
			igprj01dto.setProjectId(projectId);
			igprj01dto = prjBL.findAllProject(igprj01dto);
			IGPRJ01HistoryVO[] historyVOs = igprj01dto.getHistoryVOs();
			req.setAttribute("historyVOs", historyVOs);
			//��־���
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setCodeDetailList(igprj01dto.getCodeDetailList());
			req.setAttribute("igprj0101VO", igprj0101VO);
			return mapping.findForward("DISP");
		}else if("HISTORYDIM".equals(mapping.getParameter())){//��ʷģ����ѯ
			IGPRJ01DTO igprj01dto=new IGPRJ01DTO();
			IGPRJ0101DetailForm detailForm = (IGPRJ0101DetailForm) actionForm;
			igprj01dto.setIGPRJ0101DetailForm(detailForm);
			igprj01dto=prjBL.findAllProject(igprj01dto);
			IGPRJ01HistoryVO[] historyVOs = igprj01dto.getHistoryVOs();
			req.setAttribute("historyVOs", historyVOs);
			//��־���
			IGPRJ0101VO igprj0101VO = new IGPRJ0101VO();
			igprj0101VO.setCodeDetailList(igprj01dto.getCodeDetailList());
			req.setAttribute("igprj0101VO", igprj0101VO);
			return mapping.findForward("DISP");
		}else if ("PROJECTPLAN".equals(mapping.getParameter())) {   //��Ŀ�ƻ�
			ProjectPlanForm projectPlanForm = (ProjectPlanForm) actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
			projectPlanDTO.setProjectPlan(projectPlanForm);
			projectPlanDTO.setProjectLog(projectPlanForm);
			igprj02BL.insertEntityAction(projectPlanDTO);
			String projectId = req.getParameter("pid");
			req.setAttribute("msg", "��Ŀ�ƻ��ύ����ɹ���");
			return new ActionForward("/IGPRJ0101_Detail.do?pid=" + projectId);
		} else if ("ADJUST_PROJECTPLAN".equals(mapping.getParameter())) {  //��Ŀ����
			String projectId = req.getParameter("pid");
			ProjectPlanForm projectPlanForm = (ProjectPlanForm) actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
			projectPlanDTO.setProjectPlan(projectPlanForm);
			projectPlanDTO.setProjectId(Integer.valueOf(projectId));
			igprj02BL.adjustMSv(projectPlanDTO);
			req.setAttribute("msg", "��Ŀ�����ύ����ɹ���");
			return new ActionForward("/IGPRJ0101_Detail.do?pid=" + projectId);
		} else if ("CONFIRM_PROJECTPLAN".equals(mapping.getParameter())) {  //��̱�ȷ��
			String projectId = req.getParameter("pid");
			ProjectPlanForm confirmMSForm = (ProjectPlanForm) actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
			projectPlanDTO.setProjectPlan(confirmMSForm);
			projectPlanDTO.setProjectId(Integer.valueOf(projectId));
			igprj02BL.adjustMSv(projectPlanDTO);
			req.setAttribute("msg", "��̱�ȷ�ϴ���ɹ���");
			return new ActionForward("/IGPRJ0101_Detail.do?pid=" + projectId);
		} else if ("DETAIL_FINDFIN".equals(mapping.getParameter())) {   //��Ŀ֧����ѯ������
			String pcode = req.getParameter("pcode");
			//BLȡ��
			IGFIN01BL finBL = (IGFIN01BL) getBean("igfin01BL");
			IGFIN01DTO dto = new IGFIN01DTO();
			dto.setPcode(pcode);
			dto = finBL.findBudgetByPcode(dto);
			IGFIN01012VO ifgin01012VO = new IGFIN01012VO();
			ifgin01012VO.setBudgetIdExpenseListMap(dto.getBudgetIdExpenseListMap());
			ifgin01012VO.setBudgetIdNameMap(dto.getBudgetIdNameMap());
			req.setAttribute("ifgin01012VO", ifgin01012VO);
			return mapping.findForward("DISP");
		}else if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========��Ŀɾ������ʼ========");
			IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
			IGPRJ0101Form form = (IGPRJ0101Form)actionForm;
			igprj01dto.setProjectId(form.getPid().toString());
			prjBL.removeProject(igprj01dto);
			log.debug("========��Ŀɾ���������========");
			List<ActionMessage> messageList = igprj01dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			return mapping.findForward("DISP");
		}
		if("UPDATE_PROJECTPLAN".equals(mapping.getParameter())){
			ProjectPlanForm confirmMSForm = (ProjectPlanForm) actionForm;
			ProjectPlanDTO projectPlanDTO = new ProjectPlanDTO();
			projectPlanDTO.setProjectPlanForm(confirmMSForm);
			igprj02BL.updateProjectPlan(projectPlanDTO);
			return mapping.findForward("DISP");
		}
		addMessage(req, new ActionMessage("IGCO10000.I003"));
		return mapping.findForward("DISP");
	}

}
