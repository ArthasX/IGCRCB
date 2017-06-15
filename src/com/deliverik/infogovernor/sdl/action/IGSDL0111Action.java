/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BL;
import com.deliverik.infogovernor.scheduling.bl.IGSCH02BLImpl;
import com.deliverik.infogovernor.scheduling.dto.IGSCH01DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0101Form;
import com.deliverik.infogovernor.scheduling.vo.IGSCH01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_��ѯACTION
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSDL0111Action.class);

	/**
	 * <p>
	 * Description: ��ѯACTION
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		IGSCH0101Form form = (IGSCH0101Form)actionForm;
		// ��ȡBL�ӿ�ʵ��
		IGSCH01BL ctlBL = (IGSCH01BL) getBean("IGSCH01BL");
		
		// ʵ����DTO
		IGSCH01DTO dto = new IGSCH01DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		request.setAttribute("backUrl", request.getParameter("backUrl"));
		
		log.debug("========��ʱ�����ѯ����ʼ========");
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��ʱ�����ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ʱ�����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("SEARCH".equals(mapping.getParameter())){
			getPaginDTO(request,"IGSDL0111");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGSDL0111");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setQuartzJobsSearchCond(form);
			// ����BL��ѯ
			dto = ctlBL.searchQuartzJobs(dto);
			// ����VO
			IGSCH01011VO vo = new IGSCH01011VO();
			vo.setQuartzJobsList(dto.getQuartzJobsList());
			vo.setUser(user);
			super.<IGSCH01011VO> setVO(request, vo);
			log.debug("========��ʱ�����ѯ��������========");
		} else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========��ʱ����ɾ������ʼ========");
			dto.setQjid(form.getQjid());
			ctlBL.deleteQuartzJobs(dto);
			addMessage(request, new ActionMessage("IGSCH0101.I002"));
			log.debug("========��ʱ����ɾ����������========");
		} else if ("MODIFY_DISP".equals(mapping.getParameter())){
			dto.setQjid(form.getQjid());
			dto = ctlBL.getQuartzJobs(dto);
			IGSCH01011VO vo = new IGSCH01011VO();
			vo.setQuartzJobs(dto.getQuartzJobs());
			request.setAttribute("vo", vo);
			addMessage(request, new ActionMessage("IGCO10000.I001","�޸���Ϣ"));
			if(null == dto.getQuartzJobs().getQjendtime().trim() ||
					"".equals(dto.getQuartzJobs().getQjendtime().trim())){
				return mapping.findForward("MODIFY_ONCE");
			}
		} else if ("MODIFY".equals(mapping.getParameter())){
			IGSCH02BL sch02BL = (IGSCH02BL) getBean("IGSCH02BL");
			dto.setQjid(form.getQjid());
			String periodType = form.getPeriodType();
			String CustomDate = form.getCustomDate();
			String exeHour = form.getExeHour();
			String exeMinute = form.getExeMinute();
			String startDate = form.getQjcrttime();
			String qjtricron = this.creatCronExp(periodType, CustomDate,exeHour, exeMinute, startDate);
			String periodInfo = sch02BL.getPeriodInfo(periodType, CustomDate, 
					exeHour, exeMinute, startDate);
			form.setQjperiodinfo(periodInfo);
			form.setQjtricron(qjtricron);
			dto.setIgsch0101Form(form);
			try {
				ctlBL.updateQuartzJobs(dto);
			} catch (BLException e) {
				if(e.getErrors().get(0).getKey().equals("SchedulerException")){
					return mapping.findForward("ERROR");
				}
				log.debug(e.getMessage());
			}
			addMessage(request, new ActionMessage("IGSCH0101.I001","�޸���Ϣ���"));
		} else if("PSEARCH".equals(mapping.getParameter()) || "PSEARCH1".equals(mapping.getParameter())){
			getPaginDTO(request,"IGSDL0111");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSCH0101Form) request.getSession().getAttribute("IGSCH0101Form");
				if ( form == null ) {
					form = new IGSCH0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSDL0111");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setQuartzJobsSearchCond(form);
			// ����BL��ѯ
			dto = ctlBL.searchQuartzJobs(dto);
			// ����VO
			IGSCH01011VO vo = new IGSCH01011VO();
			vo.setQuartzJobsList(dto.getQuartzJobsList());
			vo.setUser(user);
			super.<IGSCH01011VO> setVO(request, vo);
			log.debug("========��ʱ�����ѯ��������========");
		} else if("LIST".equals(mapping.getParameter())){
			
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSDL0111");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");

			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGSCH0101Form) request.getSession().getAttribute("IGSCH0101Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			int maxCnt = getMaxDataCount("IGSDL0111");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto.setIgsch0101Form(form);
			dto = ctlBL.searchQuartzJobsByPK(dto);
			dto = ctlBL.searchQuartzJobDetailsByQjid(dto);
			
			// ����VO
			IGSCH01011VO vo = new IGSCH01011VO();
			vo.setQuartzProcessInfoList(dto.getQuartzProcessInfoList());
			vo.setQuartzJobs(dto.getQuartzJobs());
			vo.setQuartzProcessRecord(dto.getQuartzProcessRecord());
			vo.setAttachmentList(dto.getAttachmentList());
			vo.setEiname(dto.getEiname());
			vo.setCvalue(dto.getCvalue());
			//============================>>yangsn
			vo.setQuartzPieList(dto.getQuartzPieList());
			vo.setQuartzProcessInfoEntityList(dto.getQuartzProcessInfoEntityList());
			vo.setQuartzJobDetailsList(dto.getQuartzJobDetailsList());
			//<<============================yangsn
			super.<IGSCH01011VO> setVO(request, vo);
			log.debug("========��ʱ�����ѯ��������========");
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			return mapping.findForward("LISTW");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
	private String creatCronExp(String periodType, String CustomDate,
			String exeHour, String exeMinute, String startDate){
		String retCronExp = null;
		//�� �� ʱ �� �� ��
		if ("week".equals(periodType)) {
			IGSCH02BLImpl sch02BL = new IGSCH02BLImpl();
			String week = sch02BL.getWeekOfDate(startDate, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + week;
		} else if ("month".equals(periodType)){
			retCronExp = "0 " + exeMinute + " " + exeHour + " * */1 ?";
		} else if ("once".equals(periodType)){
			String day = startDate.split("/")[2];
			String month = startDate.split("/")[1];
			String year = startDate.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		} else if ("day".equals(periodType)){
			
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		} else if ("quarter".equals(periodType)){
			String day = startDate.split("/")[2];
			String month = startDate.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + "/3 ?";
		}
		log.debug(retCronExp);
		return retCronExp;
	}
	
}
